package com.lama.roadmap.repository;

import com.lama.roadmap.model.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {
}