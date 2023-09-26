package arttab.server.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class PayDto {

  private int memberNo;  //  회원번호
  private int artNo;  //  작품번호
  private int payPrice;  //  결제가격
  private Timestamp payDatetime;  // 결제일시
  private char payStatus;  //  결제상태 =>  R:입금대기중 Y:결제완료
  private int bidPrice;  // 입찰가격
  private int buyNowPrice;  // 즉시구매가
  private Timestamp endDatetime;  // 경매종료일시

}
