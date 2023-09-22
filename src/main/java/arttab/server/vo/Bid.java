package arttab.server.vo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Bid implements Serializable {
  private static final long serialVersionUID = 1L;

  private int bidNo;  //  입찰번호
  private int artNo;  //  작품번호
  private int memberNo;  //  회원번호
  private int bidPrice;  // 입찰가격
  private Timestamp bidDatetime;  //  입찰일시


}