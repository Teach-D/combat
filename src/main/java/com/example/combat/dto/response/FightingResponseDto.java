package com.example.combat.dto.response;

import com.example.combat.entity.Fighting;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FightingResponseDto {

    private LocalDateTime fightingDate;
    private String fightingName;

    public FightingResponseDto(Fighting fighting) {
        this.fightingDate = fighting.getFightingDate();
        this.fightingName = fighting.getFightingName();
    }
}
