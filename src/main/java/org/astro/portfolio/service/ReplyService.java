package org.astro.portfolio.service;

import org.astro.portfolio.dto.PageRequestDTO;
import org.astro.portfolio.dto.PageResponseDTO;
import org.astro.portfolio.dto.ReplyDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReplyService {

    PageResponseDTO<ReplyDTO> getReplyAll(Long tno , PageRequestDTO pageRequestDTO);

    Long addReply(ReplyDTO replyDTO);

    Long updateReply(ReplyDTO replyDTO);

    Long deleteReply(Long rno);
    
}
