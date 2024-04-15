package com.example.combat.entity;

import com.example.combat.dto.request.FighterRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Fighter {

    @Id @GeneratedValue
    @Column(name = "fighter_id")
    private Long id;

    private String name;
    private String nationality;
    private int age;
    private String fighterImage;

    private float height;
    private float weight;
    private float reach;

    private String style;
    @Enumerated(EnumType.STRING)
    private Division division;
    private int ranking;

    public Fighter update(FighterRequestDto requestDto) {
        this.name = requestDto.getName();
        this.nationality = requestDto.getNationality();
        this.age = requestDto.getAge();
        this.fighterImage = requestDto.getFighterImage();
        this.height = requestDto.getHeight();
        this.weight = requestDto.getWeight();
        this.reach = requestDto.getReach();
        this.style = requestDto.getStyle();
        this.division = requestDto.getDivision();
        this.ranking = requestDto.getRanking();
        return this;
    }
}
