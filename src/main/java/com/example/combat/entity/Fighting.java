package com.example.combat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Fighting {

    @Id @GeneratedValue
    @Column(name = "fighting_id")
    private Long id;

    private LocalDateTime fightingDate;

    @Column(length = 20)
    private String fightingName;

    @OneToMany(mappedBy = "fighting", cascade = CascadeType.ALL)
    private List<Fighter> fighterList = new ArrayList<>();

}
