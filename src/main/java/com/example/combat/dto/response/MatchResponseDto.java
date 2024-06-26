package com.example.combat.dto.response;

import com.example.combat.entity.Division;
import com.example.combat.entity.Fighter;
import com.example.combat.entity.Match;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchResponseDto {

    private Long matchId;
    private int sequence;
    private String division;
    private String leftFighter;
    private String rightFighter;

    public MatchResponseDto(Match match) {
        this.matchId = match.getId();
        this.sequence = match.getSequence();
        this.division = match.getDivision();
        this.leftFighter = match.getLeftFighter();
        this.rightFighter = match.getRightFighter();
    }
}
