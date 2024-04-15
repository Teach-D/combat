package com.example.combat.service;

import com.example.combat.dto.request.FighterRequestDto;
import com.example.combat.dto.request.FightingRequestDto;
import com.example.combat.entity.Fighting;
import com.example.combat.entity.Match;
import com.example.combat.repository.FighterRepository;
import com.example.combat.repository.FightingRepository;
import com.example.combat.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FightingService {

    private final FightingRepository repository;

    public Fighting save(FightingRequestDto requestDto) {
        return repository.save(requestDto.toEntity());
    }

    public Fighting save(Fighting fighting) {
        return repository.save(fighting);
    }

    public Fighting findByFightingName(String name) {
       return repository.findByFightingName(name).orElseThrow(
                () -> new IllegalArgumentException("해당 이름의 경기가 없음"));
       //return repository.findByFightingName(name);
    }

    public List<Fighting> findAll() {
        return repository.findAll();
    }

    public Fighting findById(Long id) {
        return repository.findById(id).get();
    }

    public void updateByMatch(@RequestParam String fightingName, Match match) {
        Fighting byFightingName = findByFightingName(fightingName);
        byFightingName.getMatchList().add(match);
    }

    public Fighting update(Fighting fighting, FightingRequestDto requestDto) {
        Fighting update = fighting.update(requestDto);
        return update;
    }

    public void delete(Fighting fighting) {
        repository.delete(fighting);
    }
}
