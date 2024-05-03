package com.example.combat.service;

import com.example.combat.dto.request.FighterRequestDto;
import com.example.combat.entity.Fighter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class FighterServiceTest {

    @Autowired FighterService service;

    @Test
    void 저장찾기() {
/*        FighterRequestDto dto = new FighterRequestDto();
        dto.setName("할로웨이");
        service.save(dto);
        service.findByNickname("할로웨이");*/
    }
}
