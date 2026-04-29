package com.lama.roadmap.repository;

import com.lama.roadmap.model.Roadmap;
import com.lama.roadmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {

    List<Roadmap> findByUser(User user);
    Optional<Roadmap> findTopByUserOrderByCreatedAtDesc(User user);

}