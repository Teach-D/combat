package com.example.combat.entity;

import com.example.combat.dto.request.FighterRequestDto;
import com.example.combat.dto.request.FightingRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Fighting {

    @Id @GeneratedValue
    @Column(name = "fighting_id")
    private Long id;

    private LocalDateTime fightingDate;

    @Column(length = 20)
    private String fightingName;

    @OneToMany(mappedBy = "fighting", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Match> matchList = new ArrayList<>();

    public Fighting update(FightingRequestDto requestDto) {
        this.fightingDate = requestDto.getFightingDate();
        this.fightingName = requestDto.getFightingName();
        return this;
    }

}
