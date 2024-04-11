package com.example.combat.dto.response;

import com.example.combat.entity.Record;
import com.example.combat.entity.Result;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class RecordResponseDto {

    private String opponent;
    private Result result;

    public RecordResponseDto(Record record) {
        this.opponent = record.getOpponent();
        this.result = record.getResult();
    }
}
