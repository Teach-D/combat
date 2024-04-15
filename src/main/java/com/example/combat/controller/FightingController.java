package com.example.combat.controller;

import com.example.combat.dto.request.FightingRequestDto;
import com.example.combat.dto.response.FightingResponseDto;
import com.example.combat.entity.Fighting;
import com.example.combat.service.FightingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fighting")
@RequiredArgsConstructor
public class FightingController {

    private final FightingService fightingService;

    @GetMapping("/list")
    public ResponseEntity<List<FightingResponseDto>> getFightingList() {
        List<Fighting> fightingList = fightingService.findAll();
        List<FightingResponseDto> responseDtos = new ArrayList<>();

        for (Fighting fighting : fightingList) {
            FightingResponseDto fightingResponseDto = new FightingResponseDto(fighting);
            responseDtos.add(fightingResponseDto);
        }

        return new ResponseEntity<List<FightingResponseDto>>(responseDtos, HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FightingResponseDto> findFighting(@PathVariable(value = "id") Long id) {
        Fighting savedFightingRequest = fightingService.findById(id);
        FightingResponseDto fightingResponseDto = new FightingResponseDto(savedFightingRequest);

        return new ResponseEntity<FightingResponseDto>(fightingResponseDto, HttpStatus.valueOf(200));
    }

    @PostMapping("")
    public ResponseEntity<FightingResponseDto> saveFighting(@RequestBody FightingRequestDto requestDto) {
        Fighting savedFightingRequest = fightingService.save(requestDto);
        FightingResponseDto fightingResponseDto = new FightingResponseDto(savedFightingRequest);

        return new ResponseEntity<FightingResponseDto>(fightingResponseDto, HttpStatus.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FightingResponseDto> updateFighting(@PathVariable Long id, @RequestBody FightingRequestDto requestDto) {
        Fighting findFighting = fightingService.findById(id);
        Fighting updatedFightingRequest = fightingService.update(findFighting, requestDto);
        FightingResponseDto fightingResponseDto = new FightingResponseDto(updatedFightingRequest);

        return new ResponseEntity<FightingResponseDto>(fightingResponseDto, HttpStatus.valueOf(200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFighting(@PathVariable(value = "id") Long id) {
        Fighting findFighting = fightingService.findById(id);
        fightingService.delete(findFighting);

        return new ResponseEntity(HttpStatus.valueOf(200));
    }
}