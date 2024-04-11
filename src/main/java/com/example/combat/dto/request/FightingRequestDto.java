package com.example.combat.dto.request;

import com.example.combat.entity.Fighting;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class FightingRequestDto {

    private LocalDateTime fightingDate;

    private String fightingName;


    public Fighting toEntity() {
        return Fighting.builder()
                .fightingDate(fightingDate)
                .fightingName(fightingName)
                .build();
    }
}
