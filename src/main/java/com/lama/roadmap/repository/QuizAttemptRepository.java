package com.lama.roadmap.repository;

import com.lama.roadmap.model.QuizAttempt;
import com.lama.roadmap.model.User;
import com.lama.roadmap.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByStudentAndQuiz(User student, Quiz quiz);
    int countByStudentAndQuiz(User student, Quiz quiz);
    List<QuizAttempt> findByStudent(User student);
}