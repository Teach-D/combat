package com.example.combat.repository;

import com.example.combat.entity.Division;
import com.example.combat.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FighterRepository extends JpaRepository<Fighter, Long> {

    public Optional<Fighter> findByName(String name);
    public List<Fighter> findAllByDivision(String division);

}
