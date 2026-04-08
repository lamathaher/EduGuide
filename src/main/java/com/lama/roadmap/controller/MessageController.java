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
    public Message sendMessage(@RequestBody SendMessageRequest request){
        return messageService.sendMessage(request);
    }

    @GetMapping("/assignment/{id}")
    public List<MessageResponse> getConversation(@PathVariable Long id){
        return messageService.getConversation(id);
    }

    @PutMapping("/read/{id}")
    public Message markAsRead(@PathVariable Long id){
        return messageService.markAsRead(id);
    }

}