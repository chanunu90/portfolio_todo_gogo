package org.astro.portfolio.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.astro.portfolio.dto.PageRequestDTO;
import org.astro.portfolio.dto.PageResponseDTO;
import org.astro.portfolio.dto.ReplyDTO;
import org.astro.portfolio.dto.TodoDTO;
import org.astro.portfolio.mappers.ReplyMappers;
import org.astro.portfolio.mappers.TodoMappers;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMappers replyMappers;

    @Override
    public PageResponseDTO<ReplyDTO> getReplyAll(Long tno, PageRequestDTO pageRequestDTO) {
        
        log.info("---------------ReplyServiceImpl-----------");
        log.info(pageRequestDTO.getSkip());

        List<ReplyDTO> list = replyMappers.getReplyAll(tno, pageRequestDTO);
        Long total = replyMappers.getCountReply(pageRequestDTO);

        log.info("---------------=================-----------");
        log.info(list);
        log.info("---------------=============-----------");
        return PageResponseDTO.<ReplyDTO>withAll()
        .list(list)
        .total(total)
        .build();

    }
}
