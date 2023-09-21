package arttab.server.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자 생성
public class Pay implements Serializable {
  private static final long serialVersionUID = 1L;

  private int memNo;  //  회원번호
  private int artNo;  //  작품번호
  private int payPrice;  //  결제가격
  private Timestamp payDatetime;  // 결제일시
  private char payStatus;  //  결제상태 =>  R:입금대기중 Y:결제완료

}