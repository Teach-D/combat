package com.example.combat.dto.response;

import com.example.combat.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserResponseDto {

    private String nickname;
    private String email;
    private String password;

    public UserResponseDto(User user) {
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
