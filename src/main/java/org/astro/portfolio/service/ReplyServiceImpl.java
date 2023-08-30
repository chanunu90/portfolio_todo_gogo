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
        log.info(pageRequestDTO.isReplyLast());
 
        Long total = replyMappers.getCountReply(pageRequestDTO);

        //page번호
        int pageNum = pageRequestDTO.getPage();
        //끝페이지 계산
        if(pageRequestDTO.isReplyLast()){
        //페이지 넘버에 넣어주기
            pageNum = (int) (Math.ceil(total/(double)pageRequestDTO.getSize()));

            log.info("라스트번호" + pageNum);

            //페이지번호가 0보다 작거나 같으면 1로 설정
            pageNum = pageNum <= 0 ? 1 : pageNum;

        }
        //끝페이지 번호로 설정
        pageRequestDTO.setPage(pageNum);

        List<ReplyDTO> list = replyMappers.getReplyAll(tno, pageRequestDTO);

        log.info("라스트번호" + pageRequestDTO);

        log.info("---------------=================-----------");
        log.info(list);
        log.info("---------------=================-----------");
        return PageResponseDTO.<ReplyDTO>withAll()
        .list(list)
        .total(total)
        .pageRequestDTO(pageRequestDTO)
        .build();

    }

    @Override
    public Long addReply(ReplyDTO replyDTO) {

        //댓글입력
        replyMappers.addReply(replyDTO);

        //입력된 댓글이 대댓글이 아닌경우 gno에 rno 입력
        replyMappers.updateReplyGno(replyDTO.getRno());
        
        return replyDTO.getRno();
        
    }
}
