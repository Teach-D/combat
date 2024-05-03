package com.example.combat.controller;

import com.example.combat.dto.request.FighterRequestDto;
import com.example.combat.dto.request.FightingRequestDto;
import com.example.combat.dto.response.FighterResponseDto;
import com.example.combat.dto.response.FightingResponseDto;
import com.example.combat.entity.Division;
import com.example.combat.entity.Fighter;
import com.example.combat.entity.Fighting;
import com.example.combat.service.FighterService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fighter")
@RequiredArgsConstructor
@CrossOrigin
public class FighterController {

    private final FighterService fighterService;

    @GetMapping("/list/all")
    public ResponseEntity<List<FighterResponseDto>> getAll() {
        List<Fighter> findAll = fighterService.findAll();
        List<FighterResponseDto> responseDtos = new ArrayList<>();
        for (Fighter fighter : findAll) {
            responseDtos.add(new FighterResponseDto(fighter));
        }

        return new ResponseEntity<List<FighterResponseDto>>(responseDtos, HttpStatus.valueOf(200));
    }

    @GetMapping("/list/{division}")
    public ResponseEntity<List<FighterResponseDto>> getAllByDivision(@PathVariable String division) {
        List<Fighter> findAll = fighterService.findByDivision(division);
        List<FighterResponseDto> responseDtos = new ArrayList<>();
        for (Fighter fighter : findAll) {
            responseDtos.add(new FighterResponseDto(fighter));
        }

        return new ResponseEntity<List<FighterResponseDto>>(responseDtos, HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FighterResponseDto> findById(@PathVariable(value = "id") Long id) {
        Fighter findFighter = fighterService.findById(id);
        FighterResponseDto fighterResponseDto = new FighterResponseDto(findFighter);

        return new ResponseEntity<FighterResponseDto>(fighterResponseDto, HttpStatus.valueOf(200));
    }

    @PostMapping("")
    public ResponseEntity<FighterResponseDto> saveFighter(@RequestBody FighterRequestDto requestDto) {
        String name1 = requestDto.getName();
        log.info(name1);
        Fighter savedFightingRequest = fighterService.save(requestDto);
        String name = savedFightingRequest.getName();
        log.info(name);
        FighterResponseDto fightingResponseDto = new FighterResponseDto(savedFightingRequest);

        return new ResponseEntity<FighterResponseDto>(fightingResponseDto, HttpStatus.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FighterResponseDto> updateFighter(@PathVariable Long id, @RequestBody FighterRequestDto requestDto) {
        Fighter findFighter = fighterService.findById(id);
        Fighter updatedFighter = fighterService.update(findFighter, requestDto);
        FighterResponseDto fighterResponseDto = new FighterResponseDto(updatedFighter);

        return new ResponseEntity<FighterResponseDto>(fighterResponseDto, HttpStatus.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFighter(@PathVariable Long id) {
        Fighter findFighter = fighterService.findById(id);
        fighterService.delete(findFighter);

        return new ResponseEntity(HttpStatus.valueOf(200));

    }
}
