

package com.lama.roadmap.repository;

import com.lama.roadmap.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepositry extends JpaRepository<Quiz, Long> {
    List<Quiz> findByPathAndLevel(String path, String level);
}