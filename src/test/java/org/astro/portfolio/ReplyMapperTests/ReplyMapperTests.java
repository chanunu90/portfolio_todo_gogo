package org.astro.portfolio.ReplyMapperTests;

import org.astro.portfolio.dto.PageRequestDTO;
import org.astro.portfolio.dto.ReplyDTO;
import org.astro.portfolio.mappers.ReplyMappers;
// import org.astro.portfolio.mappers.ReplyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyMapperTests {

    @Autowired
    private ReplyMappers replyMapper;

    @Test
    public void testTimasde(){
        log.info(replyMapper.time());
    }

    @Test
    public void getReplyAll(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        log.info(replyMapper.getReplyAll(4087L , pageRequestDTO));
    }

    @Test
    public void addReply(){
        ReplyDTO replyDTO = ReplyDTO.builder()
        .reply("테스트")
        .replyer("차은우")
        .tno(4087L)
        .gno(13L)
        .build();

        log.info(replyMapper.addReply(replyDTO).toString());
    }


    
}
