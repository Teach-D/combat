package com.example.combat.service;

import com.example.combat.dto.request.MatchRequestDto;
import com.example.combat.entity.Fighter;
import com.example.combat.entity.Fighting;
import com.example.combat.entity.Match;
import com.example.combat.repository.FightingRepository;
import com.example.combat.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final FightingRepository fightingRepository;

    public Match save(String fightingName, Fighter leftFighter, Fighter rightFighter, MatchRequestDto requestDto) {
        Match entity = requestDto.toEntity().builder()
                .leftFighter(leftFighter)
                .rightFighter(rightFighter)
                .sequence(requestDto.getSequence())
                .build();
        matchRepository.save(entity);
        Fighting fighting = fightingRepository.findByFightingName(fightingName).get();

        fighting.getMatchList().add(entity);
        return entity;
    }

    public Match save(Match match) {
        Match save = matchRepository.save(match);
        return save;
    }

    public Match find(Match match) {
        return matchRepository.findById(match.getId()).get();
    }

    public Match findById(Long id) {
        return matchRepository.findById(id).get();
    }

    public List<Match> findMathListByFighting(Fighting fighting) {
        return matchRepository.findAllByFighting(fighting);
    }

    public Match update(Match match, MatchRequestDto requestDto) {
        Match match1 = find(match);
        Match update = match1.update(requestDto);
        return update;
    }

    public void delete(Match match) {
        matchRepository.delete(match);
    }

}
