package com.lama.roadmap.dto;

import com.lama.roadmap.model.Role;
import java.time.LocalDateTime;
import java.util.List;

public class UserResponse {

    private Long id;
    private String fullName;
    private String email;
    private Role role;
    private String major;

    // ✅ تم التعديل هون
    private List<String> skills;

    private String interests;
 // ✅
    private List<String> expertiseFields;
    
    public List<String> getExpertiseFields() { return expertiseFields; }
    public void setExpertiseFields(List<String> expertiseFields) { this.expertiseFields = expertiseFields; }
    
    public Integer getCurrentStudents() {
		return currentStudents;
	}
	public void setCurrentStudents(Integer currentStudents) {
		this.currentStudents = currentStudents;
	}

	private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Integer yearsOfExperience;
    private String bio;
    private Integer currentStudents;

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // ✅ updated
    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}