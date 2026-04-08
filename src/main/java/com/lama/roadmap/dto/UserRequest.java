package com.lama.roadmap.dto;
import jakarta.validation.constraints.*;


public class UserRequest {
	
	
	 @NotBlank(message = "Full name is required")
	    private String fullName;

	    @Email(message = "Email must be valid")
	    @NotBlank(message = "Email is required")
	    private String email;

	    @NotBlank(message = "Password is required")
	    private String passwordHash;

	    @NotBlank(message = "Account type is required")
	    private String accountType;
	    private String major;
	    private String skills;
	    private String interests;
	    private String expertiseField;
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
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	private Integer yearsOfExperience;
	private String bio;
	
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
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getExpertiseField() {
		return expertiseField;
	}
	public void setExpertiseField(String expertiseField) {
		this.expertiseField = expertiseField;
	}
	

    // Generate Getters & Setters
}