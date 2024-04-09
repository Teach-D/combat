package com.example.combat.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Record {

    @Id @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    @Column(length = 20)
    private String opponent;

    @Enumerated(EnumType.STRING)
    private Result result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fighter_id")
    private Fighter fighter;
}
