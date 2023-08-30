package org.astro.portfolio.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDTO<E> {
  
  private List<E> list;
  private long total;
  private int page;         //라스트 페이지 번호

  @Builder(builderMethodName =  "withAll")
  public PageResponseDTO(List<E> list, long total, PageRequestDTO pageRequestDTO ){
    this.list = list;
    this.total = total;
    this.page = pageRequestDTO.getPage();
  }

}
