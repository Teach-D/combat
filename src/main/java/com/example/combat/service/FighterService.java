package com.example.combat.service;

import com.example.combat.dto.request.FighterRequestDto;
import com.example.combat.entity.Division;
import com.example.combat.entity.Fighter;
import com.example.combat.repository.FighterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FighterService {

    private final FighterRepository repository;

    public Fighter save(FighterRequestDto requestDto) {
        Fighter entity = requestDto.toEntity();
        repository.save(entity);

        return entity;
    }

    public Fighter findByNickname(String name) {
       return repository.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 이름의 선수가 등록되지 않음"));
    }

    public List<Fighter> findByDivision(Division division) {
        return repository.findAllByDivision(division);
    }

    public List<Fighter> findAll() {
        return repository.findAll();
    }

    public Fighter findById(Long id) {
        return repository.findById(id).get();
    }

    public Fighter update(Fighter fighter, FighterRequestDto requestDto) {
        Fighter update = fighter.update(requestDto);
        return update;
    }

    public void delete(Fighter fighter) {
        repository.delete(fighter);
    }
}
