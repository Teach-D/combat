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
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(length = 20)
    private String nickname;
    @Column(length = 20)
    private String email;
    @Column(length = 30)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();
}
