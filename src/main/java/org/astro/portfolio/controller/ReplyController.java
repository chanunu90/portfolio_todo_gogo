package org.astro.portfolio.controller;

import java.util.Map;

import org.astro.portfolio.dto.PageRequestDTO;
import org.astro.portfolio.dto.PageResponseDTO;
import org.astro.portfolio.dto.ReplyDTO;
import org.astro.portfolio.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
// import org.astro.portfolio.dto.ReplyDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;


    //produces: 쿼리스트링을 json 형식으로 바꿔준다.
    @GetMapping(value = "/{tno}/list",  produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseDTO<ReplyDTO> getReplyList(@PathVariable("tno") Long tno ,  PageRequestDTO pageRequestDTO){
        
        
        log.info("----------------------------------------------" + tno);
        log.info("----------------------------------------------" + tno);
        log.info("----------------------------------------------" + tno);
        log.info("----------------------------------------------" + pageRequestDTO);


        
        return replyService.getReplyAll(tno, pageRequestDTO);

    }
    
}
