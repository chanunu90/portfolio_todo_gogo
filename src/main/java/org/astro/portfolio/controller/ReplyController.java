package org.astro.portfolio.controller;

import java.util.Map;

import org.astro.portfolio.dto.PageRequestDTO;
import org.astro.portfolio.dto.PageResponseDTO;
import org.astro.portfolio.dto.ReplyDTO;
import org.astro.portfolio.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.astro.portfolio.dto.ReplyDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    //produces: 쿼리스트링을 json 형식으로 바꿔준다.
    @GetMapping(value = "/{tno}/list",  produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseDTO<ReplyDTO> getReplyList(@PathVariable("tno") Long tno, boolean replyLast ,PageRequestDTO pageRequestDTO){
        
        log.info("----------------------------------------------" + tno);
        log.info("----------------------------------------------" + tno);
        log.info("----------------------------------------------" + replyLast);
        log.info("----------------------------------------------" + pageRequestDTO.isReplyLast());
       
        pageRequestDTO.setReplyLast(replyLast);

        log.info("----------------------pageRequestDTO------------------------" + pageRequestDTO);

        // log.info("----------------------------------------------" + pageRequestDTO);
                
        return replyService.getReplyAll(tno, pageRequestDTO);
        
    }

    @PostMapping(value="")
    public Map<String , Long> addReply(@RequestBody ReplyDTO replyDTO) {

        log.info("==================================================");
        log.info(replyDTO);
        log.info("--------------------------------------------------");
                
        return Map.of("result", replyService.addReply(replyDTO));
        
    }

    @PutMapping(value = "")
    public Map<String , String> updateReply(@RequestBody ReplyDTO replyDTO){

        log.info("==================================================");
        log.info(replyDTO);
        log.info("--------------------------------------------------");
        replyService.updateReply(replyDTO);
                
        return Map.of("result", "clear");
    }

    @DeleteMapping(value = "{rno}")
    public Map<String , String> deleteReply(@PathVariable("rno") Long rno){

        log.info("===================rno===============================");
        log.info(rno);
        log.info("--------------------rno------------------------------");
        replyService.deleteReply(rno);
                
        return Map.of("result", "clear");
    }
    
    
}
