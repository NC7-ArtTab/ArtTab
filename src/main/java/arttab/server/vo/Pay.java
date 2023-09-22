package arttab.server.vo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pay implements Serializable {
  private static final long serialVersionUID = 1L;

  private int memberNo;  //  회원번호
  private int artNo;  //  작품번호
  private int payPrice;  //  결제가격
  private Timestamp payDatetime;  // 결제일시
  private char payStatus;  //  결제상태 =>  R:입금대기중 Y:결제완료

}