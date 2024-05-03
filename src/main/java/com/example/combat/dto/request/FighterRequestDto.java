package com.example.combat.dto.request;

import com.example.combat.entity.Division;
import com.example.combat.entity.Fighter;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class FighterRequestDto {

    private String name;
    private String nationality;
    private int age;
    private String fighterImage;

    private float height;
    private float weight;
    private float reach;

    private String style;
    private String division;
    private int ranking;

    public Fighter toEntity() {
        return Fighter.builder()
                .name(name)
                .nationality(nationality)
                .age(age)
                .fighterImage(fighterImage)
                .height(height)
                .weight(weight)
                .reach(reach)
                .style(style)
                .division(division)
                .ranking(ranking)
                .build();

    }
}
