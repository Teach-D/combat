package com.example.combat.repository;

import com.example.combat.entity.Fighting;
import com.example.combat.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByFighting(Fighting fighting);
}
