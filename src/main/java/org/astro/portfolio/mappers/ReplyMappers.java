package org.astro.portfolio.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.message.Message;
import org.astro.portfolio.dto.PageRequestDTO;
import org.astro.portfolio.dto.PageResponseDTO;
import org.astro.portfolio.dto.ReplyDTO;
// import org.astro.portfolio.dto.ReplyDTO;
import org.astro.portfolio.dto.TodoDTO;

public interface ReplyMappers {

    String time();

    List<ReplyDTO> getReplyAll(@Param("tno") Long tno , @Param("pr") PageRequestDTO pageRequestDTO);

    Long getCountReply(PageRequestDTO pageRequestDTO);

    Long addReply(ReplyDTO replyDTO);
    
    Long updateReplyGno(Long rno);

    Long updateReply(ReplyDTO replyDTO);
    
    Long deleteReply(Long rno);
    
    
}
