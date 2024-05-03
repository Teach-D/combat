/*
package com.example.combat.service;

import com.example.combat.dto.request.FighterRequestDto;
import com.example.combat.dto.request.FightingRequestDto;
import com.example.combat.dto.request.MatchRequestDto;
import com.example.combat.dto.response.FighterResponseDto;
import com.example.combat.entity.Fighter;
import com.example.combat.entity.Fighting;
import com.example.combat.entity.Match;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootTest
@Transactional
public class FightingServiceTest {

    @Autowired private FighterService fighterService;
    @Autowired private FightingService fightingService;
    @Autowired private MatchService matchService;

    @Test
    void save테스트() {
        */
/*FighterRequestDto fighterRequestDto1 = new FighterRequestDto();
        FighterRequestDto fighterRequestDto2 = new FighterRequestDto();
        FighterRequestDto fighter1 = fighterRequestDto1.builder().name("fighter1").build();
        FighterRequestDto fighter2 = fighterRequestDto2.builder().name("fighter2").build();

        fighterService.save(fighter1);
        fighterService.save(fighter2);

        FightingRequestDto fightingRequestDto = new FightingRequestDto();
        FightingRequestDto ufc300 = fightingRequestDto.builder().fightingName("ufc300").build();
        fightingService.save(ufc300);

        MatchRequestDto matchRequestDto = new MatchRequestDto();
        MatchRequestDto build = matchRequestDto.builder().sequence(1).build();
        matchService.save("ufc300", fighter1.toEntity(), fighter2.toEntity(), build);

        List<Fighting> all = fightingService.findAll();
        for (Fighting fighting : all) {
            log.info("fighting name = {}", fighting.getFightingName());
            for (Match match : fighting.getMatchList()) {
                log.info("match sequence = {}", match.getSequence());
                log.info("match leftFighterName = {}", match.getLeftFighter());
                log.info("match rightFighterName = {}", match.getRightFighter());
            }

        }*//*


    }

    @Test
    @Rollback(false)
    @Commit
    void update테스트() {
        //given
        FighterRequestDto fighterRequestDto1 = new FighterRequestDto();
        FighterRequestDto fighterRequestDto2 = new FighterRequestDto();
        FighterRequestDto fighter1 = fighterRequestDto1.builder().name("fighter1").build();
        FighterRequestDto fighter2 = fighterRequestDto2.builder().name("fighter2").build();

        fighterService.save(fighter1);
        fighterService.save(fighter2);

        FighterRequestDto fighterRequestDto3 = new FighterRequestDto();
        FighterRequestDto fighterRequestDto4 = new FighterRequestDto();
        FighterRequestDto fighter3 = fighterRequestDto3.builder().name("fighter3").build();
        FighterRequestDto fighter4 = fighterRequestDto4.builder().name("fighter4").build();

        fighterService.save(fighter3);
        fighterService.save(fighter4);

        //when
        MatchRequestDto matchRequestDto = new MatchRequestDto();
        Match matchEntity = matchRequestDto.builder().sequence(1).build().toEntity();

        Fighter entity1 = fighterService.findByNickname("fighter1");
        Fighter entity2 = fighterService.findByNickname("fighter2");

        matchEntity.createMatch(entity1, entity2);

        matchService.save(matchEntity);

        MatchRequestDto matchRequestDto1 = new MatchRequestDto();
        Match matchEntity1 = matchRequestDto.builder().sequence(2).build().toEntity();

        Fighter entity3 = fighterService.findByNickname("fighter3");
        Fighter entity4 = fighterService.findByNickname("fighter4");

        matchEntity1.createMatch(entity3, entity4);

        matchService.save(matchEntity1);

        entity1.setName("fighter3");
        log.info(String.valueOf(matchEntity.getRightFighter()));

        FightingRequestDto fightingRequestDto = new FightingRequestDto();
        FightingRequestDto requestUfc300 = fightingRequestDto.builder().fightingName("ufc300").build();
        Fighting ufc300Entity = requestUfc300.toEntity();

        ufc300Entity.getMatchList().add(matchEntity);
        ufc300Entity.getMatchList().add(matchEntity1);

        fightingService.save(ufc300Entity);

        matchEntity.setSequence(3);
        ufc300Entity.setFightingName("ufc3001");
        //then
        List<Fighting> all = fightingService.findAll();
        for (Fighting fighting : all) {
            log.info("fighting name = {}", fighting.getFightingName());
            for (Match match : fighting.getMatchList()) {
                log.info("match sequence = {}", match.getSequence());
                log.info("match leftFighterName = {}", match.getLeftFighter().getName());
                log.info("match rightFighterName = {}", match.getRightFighter().getName());
            }

        }

    }


}
*/
