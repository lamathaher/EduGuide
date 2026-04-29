package com.lama.roadmap.controller;

import com.lama.roadmap.dto.SendMessageRequest;
import com.lama.roadmap.model.Message;
import com.lama.roadmap.service.MessageService;
import com.lama.roadmap.dto.MessageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping
    public MessageResponse sendMessage(@RequestBody SendMessageRequest request){
        return messageService.sendMessage(request);
    }

    @GetMapping("/assignment/{id}")
    public List<MessageResponse> getConversation(
            @PathVariable Long id,
            @RequestParam Long userId
    ){
        return messageService.getConversation(id, userId);
    }
    @PutMapping("/read/{id}")
    public Message markAsRead(
            @PathVariable Long id,
            @RequestParam Long userId
    ){
        return messageService.markAsRead(id, userId);
    }

    @PutMapping("/read/assignment/{assignmentId}")
    public void markConversationAsRead(
            @PathVariable Long assignmentId,
            @RequestParam Long userId
    ){
        messageService.markConversationAsRead(assignmentId, userId);
    }
}