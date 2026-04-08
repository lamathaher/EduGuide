package com.lama.roadmap.dto;

import java.time.LocalDateTime;

public class MessageResponse {

    private Long id;
    private Long senderId;
    private String senderName;
    private String senderRole;
    private String content;
    private Boolean isRead;
    private LocalDateTime createdAt;

    public MessageResponse() {}

    public MessageResponse(Long id, Long senderId, String senderName,
                           String senderRole, String content,
                           Boolean isRead, LocalDateTime createdAt) {
        this.id = id;
        this.senderId = senderId;
        this.senderName = senderName;
        this.senderRole = senderRole;
        this.content = content;
        this.isRead = isRead;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderRole() {
        return senderRole;
    }

    public String getContent() {
        return content;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}