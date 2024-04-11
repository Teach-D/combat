package com.example.combat.dto.request;

import com.example.combat.entity.Division;
import com.example.combat.entity.Match;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDto {

    private int sequence;
    private Division division;
    private String leftFighter;
    private String rightFighter;

    public Match toEntity() {
        return Match.builder()
                .sequence(sequence)
                .division(division)
                .leftFighter(leftFighter)
                .rightFighter(rightFighter)
                .build();
    }
}
