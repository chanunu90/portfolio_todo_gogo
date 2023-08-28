package org.astro.portfolio.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyDTO {
    
    private Long rno;
    private Long tno;
    private Long gno;

    private Long step;

    private boolean delFlag;

    private String reply;
    private String replyer;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate replydate;

}
