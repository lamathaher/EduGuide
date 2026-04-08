package com.lama.roadmap.service;

import com.lama.roadmap.dto.LoginRequest;
import com.lama.roadmap.dto.UserRequest;
import com.lama.roadmap.dto.UserResponse;
import com.lama.roadmap.model.Role;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
        // ROLE + STATUS 🔥
        // =========================
        if ("STUDENT".equalsIgnoreCase(request.getAccountType())) {
            user.setRole(Role.USER);
            user.setStatus("active"); // ✅ الطالب مباشرة active

        } else if ("INSTRUCTOR".equalsIgnoreCase(request.getAccountType())) {
            user.setRole(Role.INSTRUCTOR_PENDING);
            user.setStatus("pending"); // ✅ المدرس pending

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

            if (request.getExpertiseField() == null || request.getExpertiseField().isBlank()) {
                throw new RuntimeException("Expertise field is required for instructors");
            }

            if (request.getYearsOfExperience() == null || request.getYearsOfExperience() < 0) {
                throw new RuntimeException("Valid years of experience is required for instructors");
            }

            if (request.getBio() == null || request.getBio().isBlank()) {
                throw new RuntimeException("Bio is required for instructors");
            }
        }

        // =========================
        // SET باقي الحقول
        // =========================
        if ("STUDENT".equalsIgnoreCase(request.getAccountType())) {
            user.setMajor(request.getMajor());
            user.setSkills(request.getSkills());
            user.setInterests(request.getInterests());
        }

        if ("INSTRUCTOR".equalsIgnoreCase(request.getAccountType())) {
            user.setExpertiseField(request.getExpertiseField());
            user.setYearsOfExperience(request.getYearsOfExperience());
            user.setBio(request.getBio());
        }
        // ❌ حذفنا status من الفرونت

        User savedUser = userRepository.save(user);

        return convertToResponse(savedUser);
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPasswordHash())) {
            throw new RuntimeException("Invalid email or password");
        }

        return "Login successful";
    }

    public List<UserResponse> getPendingInstructors() {
        return userRepository.findByRole(Role.INSTRUCTOR_PENDING)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public UserResponse approveInstructor(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (user.getRole() != Role.INSTRUCTOR_PENDING) {
            throw new RuntimeException("User is not pending instructor");
        }

        user.setRole(Role.INSTRUCTOR);
        user.setStatus("active"); // 🔥 مهم جداً بعد الموافقة

        User savedUser = userRepository.save(user);

        return convertToResponse(savedUser);
    }

    private UserResponse convertToResponse(User user) {

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setMajor(user.getMajor());
        response.setSkills(user.getSkills());
        response.setInterests(user.getInterests());
        response.setExpertiseField(user.getExpertiseField());
        response.setYearsOfExperience(user.getYearsOfExperience());
        response.setBio(user.getBio());
        response.setStatus(user.getStatus());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return response;
    }
}