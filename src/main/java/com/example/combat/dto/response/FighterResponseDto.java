package com.example.combat.dto.response;

import com.example.combat.entity.Division;
import com.example.combat.entity.Fighter;
import lombok.Getter;

@Getter
public class FighterResponseDto {

    private String name;
    private String nationality;
    private int age;
    private String fighterImage;

    private float height;
    private float weight;
    private float reach;

    private String style;
    private Division division;
    private int ranking;



    public FighterResponseDto(Fighter fighter) {
        this.name = fighter.getName();
        this.nationality = fighter.getNationality();
        this.age = fighter.getAge();
        this.fighterImage = fighter.getFighterImage();
        this.height = fighter.getHeight();
        this.weight = fighter.getWeight();
        this.reach = fighter.getReach();
        this.style = fighter.getStyle();
        this.division = fighter.getDivision();
        this.ranking = fighter.getRanking();
    }
}
