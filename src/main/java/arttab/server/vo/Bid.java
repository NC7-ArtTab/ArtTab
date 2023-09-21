package arttab.server.vo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 생성
public class Bid implements Serializable {
  private static final long serialVersionUID = 1L;

  private int bidNo;  //  입찰번호
  private int artNo;  //  작품번호
  private int memNo;  //  회원번호
  private int bidPrice;  // 입찰가격
  private Timestamp bidDatetime;  //  입찰일시

}