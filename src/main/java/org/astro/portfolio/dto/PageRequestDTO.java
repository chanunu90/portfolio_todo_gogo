package org.astro.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PageRequestDTO {

  //검색 할때 넣을것들
  //타입
  private String types;
  //내용
  private String keyword;

  
  @Builder.Default
  private int page = 1;
  @Builder.Default
  private int size = 10;
  @Builder.Default
  private boolean replyLast=false; //댓글 페이지 마지막 페이지 유무

  public void setReplyLast(boolean replyLast) {
    this.replyLast = replyLast;
  }

  public void setPage(int page){
    if(page <= 0){
      this.page = 1;
    }else {
      this.page = page;
    }
  }

  public void setSize(int size){
    if(size > 100 || size < 0){
      this.size = 10;
    }else {
      this.size = size;
    }
  }

  public int getSkip(){
    return (this.page -1) * this.size;
  }

  public int getEnd(){
    return this.page * this.size;
  }

  public int getCountEnd() {

    int temp = (int) (Math.ceil(this.page/10.0)) * (10 * size);

    return temp + 1;
  }
}
