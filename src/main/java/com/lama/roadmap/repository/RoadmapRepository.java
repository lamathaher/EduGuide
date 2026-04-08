package com.lama.roadmap.repository;

import com.lama.roadmap.model.Roadmap;
import com.lama.roadmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {

    List<Roadmap> findByUser(User user);
}