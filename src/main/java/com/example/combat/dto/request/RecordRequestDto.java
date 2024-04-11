package com.example.combat.dto.request;

import com.example.combat.entity.Record;
import com.example.combat.entity.Result;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecordRequestDto {

    private String opponent;
    private Result result;

    public Record toEntity() {
        return Record.builder()
                .opponent(opponent)
                .result(result)
                .build();
    }
}
