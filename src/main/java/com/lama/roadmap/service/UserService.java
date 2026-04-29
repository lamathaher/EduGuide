package com.lama.roadmap.service;

import com.lama.roadmap.dto.LoginRequest;
import com.lama.roadmap.dto.UserRequest;
import com.lama.roadmap.dto.UserResponse;
import com.lama.roadmap.model.ExpertiseField;
import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.model.Role;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.lama.roadmap.repository.InstructorAssignmentRepository;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final InstructorAssignmentRepository assignmentRepository;
    
    public UserService(UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            InstructorAssignmentRepository assignmentRepository) {
this.userRepository = userRepository;
this.passwordEncoder = passwordEncoder;
this.assignmentRepository = assignmentRepository;
}

    // =========================
    // CREATE USER
    // =========================
    public UserResponse createUser(UserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(
                passwordEncoder.encode(request.getPasswordHash())
        );

        // =========================
        // ROLE
        // =========================
        if ("STUDENT".equalsIgnoreCase(request.getAccountType())) {
            user.setRole(Role.USER);

        } else if ("INSTRUCTOR".equalsIgnoreCase(request.getAccountType())) {
            user.setRole(Role.INSTRUCTOR_PENDING);

        } else {
            throw new RuntimeException("Invalid account type");
        }

        // =========================
        // VALIDATION
        // =========================
        if ("STUDENT".equalsIgnoreCase(request.getAccountType())) {

            if (request.getMajor() == null || request.getMajor().isBlank()) {
                throw new RuntimeException("Major is required for students");
            }
        }

        if ("INSTRUCTOR".equalsIgnoreCase(request.getAccountType())) {

            if (request.getExpertiseFields() == null || request.getExpertiseFields().isEmpty()) {
                throw new RuntimeException("At least one expertise field is required for instructors");
            }

            if (request.getExpertiseFields().size() > 5) {
                throw new RuntimeException("You can select up to 5 expertise fields only");
            }

            if (request.getYearsOfExperience() == null || request.getYearsOfExperience() < 0) {
                throw new RuntimeException("Valid years of experience is required for instructors");
            }

            if (request.getBio() == null || request.getBio().isBlank()) {
                throw new RuntimeException("Bio is required for instructors");
            }
        }

        // =========================
        // SET EXTRA FIELDS
        // =========================
        if ("STUDENT".equalsIgnoreCase(request.getAccountType())) {
            user.setMajor(request.getMajor());
            user.setSkills(request.getSkills());
            user.setInterests(request.getInterests());
        }

        if ("INSTRUCTOR".equalsIgnoreCase(request.getAccountType())) {

            // ✅ SAFE conversion (بدون crash)
            List<ExpertiseField> fields = request.getExpertiseFields()
                    .stream()
                    .map(f -> {
                        try {
                            return ExpertiseField.valueOf(f.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            throw new RuntimeException("Invalid expertise field: " + f);
                        }
                    })
                    .toList();

            user.setExpertiseFields(fields);

            user.setYearsOfExperience(request.getYearsOfExperience());
            user.setBio(request.getBio());
            user.setSkills(request.getSkills());
        }

        User savedUser = userRepository.save(user);

        return convertToResponse(savedUser);
    }

    // =========================
    // LOGIN
    // =========================
    public User login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPasswordHash())) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }

    // =========================
    // GET PENDING INSTRUCTORS
    // =========================
    public List<UserResponse> getPendingInstructors() {
        return userRepository.findByRole(Role.INSTRUCTOR_PENDING)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // =========================
    // APPROVE INSTRUCTOR
    // =========================
    public UserResponse approveInstructor(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (user.getRole() != Role.INSTRUCTOR_PENDING) {
            throw new RuntimeException("User is not pending instructor");
        }

        user.setRole(Role.INSTRUCTOR);

        User savedUser = userRepository.save(user);

        return convertToResponse(savedUser);
    }

    // =========================
    // CONVERT TO DTO
    // =========================
    public UserResponse convertToResponse(User user) {

        UserResponse response = new UserResponse();
        response.setCurrentStudents(
        	    assignmentRepository.findByInstructor(user)
        	        .stream()
        	        .filter(InstructorAssignment::isActive)
        	        .toList()
        	        .size()
        	);
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setMajor(user.getMajor());
        response.setSkills(user.getSkills());
        response.setInterests(user.getInterests());

        // ✅ expertise fields
        if (user.getExpertiseFields() != null && !user.getExpertiseFields().isEmpty()) {
            response.setExpertiseFields(
                    user.getExpertiseFields()
                            .stream()
                            .map(Enum::name)
                            .toList()
            );
        }

        response.setYearsOfExperience(user.getYearsOfExperience());
        response.setBio(user.getBio());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return response;
    }

    // =========================
    // FILTER INSTRUCTORS
    // =========================
    public List<UserResponse> getInstructorsByField(ExpertiseField field){
        return userRepository.findByExpertiseFieldsContaining(field)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    public List<UserResponse> getAllInstructors(){
        return userRepository.findByRole(Role.INSTRUCTOR)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    
    public List<UserResponse> getTopInstructors(){
        return userRepository.findByRole(Role.INSTRUCTOR)
                .stream()
                .limit(4)
                .map(this::convertToResponse)
                .toList();
    }
    
    public int getActiveStudentsCount(User instructor){
        return (int) assignmentRepository
                .findByInstructor(instructor)
                .stream()
                .filter(InstructorAssignment::isActive)
                .count();
    }
    
    
}