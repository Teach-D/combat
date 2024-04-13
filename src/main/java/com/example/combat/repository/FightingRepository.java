package com.example.combat.repository;

import com.example.combat.entity.Fighting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FightingRepository extends JpaRepository<Fighting, Long> {

    public Optional<Fighting> findByFightingName(String name);

}
