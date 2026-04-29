package com.lama.roadmap.service;

import com.lama.roadmap.dto.SendMessageRequest;
import com.lama.roadmap.dto.MessageResponse;
import com.lama.roadmap.model.Message;
import com.lama.roadmap.model.Message.MessageType;
import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.MessageRepository;
import com.lama.roadmap.repository.InstructorAssignmentRepository;
import com.lama.roadmap.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final InstructorAssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public MessageService(
            MessageRepository messageRepository,
            InstructorAssignmentRepository assignmentRepository,
            UserRepository userRepository,
            NotificationService notificationService) {

        this.messageRepository = messageRepository;
        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public MessageResponse sendMessage(SendMessageRequest request){
        InstructorAssignment assignment = assignmentRepository.findById(request.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        // ✅ منع الإرسال إذا منتهي
        if(Boolean.FALSE.equals(assignment.isActive())){
            throw new RuntimeException("This conversation is closed");
        }

        User sender = userRepository.findById(request.getSenderId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ تأكد إنه sender جزء من الشات
        if(!sender.getId().equals(assignment.getStudent().getId()) &&
           !sender.getId().equals(assignment.getInstructor().getId())) {
            throw new RuntimeException("User not part of this conversation");
        }

        Message message = new Message();
        message.setAssignment(assignment);
        message.setSender(sender);
        message.setContent(request.getContent());
        message.setType(MessageType.TEXT);

        Message savedMessage = messageRepository.save(message);

        // تحديد المستقبل
        User receiver = sender.getId().equals(assignment.getStudent().getId())
                ? assignment.getInstructor()
                : assignment.getStudent();

        // ✅ حماية من null + تقصير النص
        String content = request.getContent() != null ? request.getContent() : "";
        String preview = content.length() > 40 ? content.substring(0, 40) + "..." : content;

        notificationService.createNotification(
        	    receiver.getId(),
        	    "New Message 💬",
        	    sender.getFullName() + ": " + preview,
        	    "CHAT",
        	    assignment.getId() // 🔥 أهم تغيير
        	);

        return new MessageResponse(
                savedMessage.getId(),
                savedMessage.getSender().getId(),
                savedMessage.getSender().getFullName(),
                savedMessage.getSender().getRole().toString(),
                savedMessage.getContent(),
                savedMessage.getIsRead(),
                savedMessage.getCreatedAt(),
                savedMessage.getType().toString()
        );    }

    @Transactional
    public void markConversationAsRead(Long assignmentId, Long userId) {

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        if(!assignment.getStudent().getId().equals(userId) &&
           !assignment.getInstructor().getId().equals(userId)) {
            throw new RuntimeException("User not part of this conversation");
        }

        // ✅ علم الرسائل كمقروءة
        messageRepository.markAllAsRead(assignmentId, userId);

        // ✅🔥 الجديد: علم إشعارات الشات كمقروءة
        notificationService.markChatNotificationsAsRead(userId, assignmentId);
    }

    public List<MessageResponse> getConversation(Long assignmentId, Long userId){
        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        List<Message> messages = messageRepository
                .findByAssignmentOrderByCreatedAtAsc(assignment);
        if(!assignment.getStudent().getId().equals(userId) &&
        		   !assignment.getInstructor().getId().equals(userId)) {
        		    throw new RuntimeException("User not part of this conversation");
        		}
        return messages.stream()
                .map(m -> new MessageResponse(
                        m.getId(),
                        m.getSender().getId(),
                        m.getSender().getFullName(),
                        m.getSender().getRole().toString(),
                        m.getContent(),
                        m.getIsRead(),
                        m.getCreatedAt(),
                        m.getType() != null ? m.getType().toString() : "TEXT" // ✅ حماية
                ))
                .toList();
    }

    public Message markAsRead(Long messageId, Long userId){

        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));

        InstructorAssignment assignment = message.getAssignment();

        // ✅ security check
        if(!assignment.getStudent().getId().equals(userId) &&
           !assignment.getInstructor().getId().equals(userId)) {
            throw new RuntimeException("User not part of this conversation");
        }

        // ✅ optimization
        if(Boolean.TRUE.equals(message.getIsRead())){
            return message;
        }

        message.setIsRead(true);
        return messageRepository.save(message);
    }
}