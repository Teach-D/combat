package com.example.combat.controller;

import com.example.combat.dto.request.MatchRequestDto;
import com.example.combat.dto.response.FightingResponseDto;
import com.example.combat.dto.response.MatchResponseDto;
import com.example.combat.entity.Fighter;
import com.example.combat.entity.Fighting;
import com.example.combat.entity.Match;
import com.example.combat.service.FighterService;
import com.example.combat.service.FightingService;
import com.example.combat.service.MatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
@CrossOrigin
public class MatchController {

    private final MatchService matchService;
    private final FighterService fighterService;
    private final FightingService fightingService;

    @GetMapping("/list/{fightingId}")
    public ResponseEntity<List<MatchResponseDto>> findList(@PathVariable(value = "fightingId") Long fightingId) {
        Fighting findFighting = fightingService.findById(fightingId);
        List<Match> mathListByFighting = matchService.findMathListByFighting(findFighting);
        List<MatchResponseDto> responseDtos = new ArrayList<>();

        for (Match match : mathListByFighting) {
            responseDtos.add(new MatchResponseDto(match));
        }

        return new ResponseEntity<List<MatchResponseDto>>(responseDtos, HttpStatus.valueOf(200));

    }

    @GetMapping("/{matchId}")
    public ResponseEntity<MatchResponseDto> findMatch(@PathVariable(value = "matchId") Long matchId) {
        Match findMatch = matchService.findById(matchId);
        MatchResponseDto matchResponseDto = new MatchResponseDto(findMatch);

        return new ResponseEntity<MatchResponseDto>(matchResponseDto, HttpStatus.valueOf(200));
    }

    @PostMapping("/{fightingId}")
    public ResponseEntity<MatchResponseDto> saveByFighting(@PathVariable(value = "fightingId") Long fightingId, @RequestBody MatchRequestDto matchRequestDto) {
        Fighting findFighting = fightingService.findById(fightingId);

        Match matchRequestDtoEntity = matchRequestDto.toEntity();
        matchRequestDtoEntity.setFighting(findFighting);

        Match savedMatch = matchService.save(matchRequestDtoEntity);

        findFighting.getMatchList().add(matchRequestDtoEntity);

        MatchResponseDto matchResponseDto = new MatchResponseDto(savedMatch);

        return new ResponseEntity<MatchResponseDto>(matchResponseDto, HttpStatus.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchResponseDto> update(@PathVariable(value = "id") Long MatchId, @RequestBody MatchRequestDto requestDto) {
        Match findMatch = matchService.findById(MatchId);
        Match updatedMatch = matchService.update(findMatch, requestDto);
        MatchResponseDto matchResponseDto = new MatchResponseDto(updatedMatch);

        return new ResponseEntity<MatchResponseDto>(matchResponseDto, HttpStatus.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long matchId) {
        Match findMatch = matchService.findById(matchId);
        matchService.delete(findMatch);

        return new ResponseEntity(HttpStatus.valueOf(200));
    }
}
