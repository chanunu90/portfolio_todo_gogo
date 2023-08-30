package org.astro.portfolio.dto;

import java.util.ArrayList;
import java.util.List;

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
public class TodoImageDTO {
  
  private Long image_tno;

  //DB 처리 용도
  private String image;

  @Builder.Default
  private List<String> images = new ArrayList<>();

  private int ord;
  
}
