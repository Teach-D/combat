package com.example.combat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fighting_id")
    private Fighting fighting;

    @OneToMany(mappedBy = "fighter", cascade = CascadeType.ALL)
    private List<Record> recordList = new ArrayList<>();

}
