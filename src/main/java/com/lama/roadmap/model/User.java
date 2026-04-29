package com.lama.roadmap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String passwordHash;

    private LocalDateTime lastActivityAt;
    private LocalDateTime lastReminderSentAt;

    private Integer yearsOfExperience;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(name = "last_opened_roadmap_id")
    private Long lastOpenedRoadmapId;

    @Enumerated(EnumType.STRING)
    private Role role;

    // =========================
    // USER fields
    // =========================
    private String major;

    @ElementCollection
    private List<String> skills;

    @Column(columnDefinition = "TEXT")
    private String interests;

    // =========================
    // INSTRUCTOR fields
    // =========================
 // ✅ الجديد
 // ✅ الجديد
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ExpertiseField> expertiseFields;
    
    public List<ExpertiseField> getExpertiseFields() { return expertiseFields; }
    public void setExpertiseFields(List<ExpertiseField> expertiseFields) { this.expertiseFields = expertiseFields; }

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // =========================
    // Lifecycle
    // =========================
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // =========================
    // Getters & Setters
    // =========================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public LocalDateTime getLastActivityAt() { return lastActivityAt; }
    public void setLastActivityAt(LocalDateTime lastActivityAt) { this.lastActivityAt = lastActivityAt; }

    public LocalDateTime getLastReminderSentAt() { return lastReminderSentAt; }
    public void setLastReminderSentAt(LocalDateTime lastReminderSentAt) { this.lastReminderSentAt = lastReminderSentAt; }

    public Integer getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(Integer yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public Long getLastOpenedRoadmapId() { return lastOpenedRoadmapId; }
    public void setLastOpenedRoadmapId(Long lastOpenedRoadmapId) { this.lastOpenedRoadmapId = lastOpenedRoadmapId; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    public String getInterests() { return interests; }
    public void setInterests(String interests) { this.interests = interests; }


    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}