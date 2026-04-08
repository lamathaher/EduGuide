package com.lama.roadmap.service;

import com.lama.roadmap.dto.SendMessageRequest;
import com.lama.roadmap.dto.MessageResponse;
import com.lama.roadmap.model.Message;
import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.MessageRepository;
import com.lama.roadmap.repository.InstructorAssignmentRepository;
import com.lama.roadmap.repository.UserRepository;
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

    public Message sendMessage(SendMessageRequest request){

        InstructorAssignment assignment = assignmentRepository.findById(request.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        User sender = userRepository.findById(request.getSenderId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Message message = new Message();
        message.setAssignment(assignment);
        message.setSender(sender);
        message.setContent(request.getContent());

        Message savedMessage = messageRepository.save(message);

        // تحديد المستقبل (الطالب أو المدرس)
        User receiver;

        if(sender.getId().equals(assignment.getStudent().getId())){
            receiver = assignment.getInstructor();
        } else {
            receiver = assignment.getStudent();
        }

        // إنشاء Notification
        notificationService.createNotification(
                receiver.getId(),
                "New Message",
                sender.getFullName() + " sent you a message",
                "message",
                savedMessage.getId()
        );

        return savedMessage;
    }

    public List<MessageResponse> getConversation(Long assignmentId){

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        List<Message> messages = messageRepository
                .findByAssignmentOrderByCreatedAtAsc(assignment);

        return messages.stream()
                .map(m -> new MessageResponse(
                        m.getId(),
                        m.getSender().getId(),
                        m.getSender().getFullName(),
                        m.getSender().getRole().toString(),
                        m.getContent(),
                        m.getIsRead(),
                        m.getCreatedAt()
                ))
                .toList();
    }

    public Message markAsRead(Long messageId){

        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));

        message.setIsRead(true);

        return messageRepository.save(message);
    }

}