package com.example.combat.entity;

import com.example.combat.dto.request.MatchRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Match {

    @Id @GeneratedValue
    @Column(name = "match_id")
    private Long id;

    private int sequence;
    @Enumerated(EnumType.STRING)
    private Division division;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fighting_id")
    private Fighting fighting;

    @OneToOne
    private Fighter leftFighter;
    @OneToOne
    private Fighter rightFighter;

    public Match createMatch(Fighter leftFighter, Fighter rightFighter) {
        this.leftFighter = leftFighter;
        this.rightFighter = rightFighter;
        return this;
    }

    public Match update(MatchRequestDto requestDto) {
        this.sequence = requestDto.getSequence();
        this.division = requestDto.getDivision();
        this.leftFighter = requestDto.getLeftFighter();
        this.rightFighter = requestDto.getRightFighter();
        return this;
    }
}
