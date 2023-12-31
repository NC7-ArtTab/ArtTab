package arttab.server.dto;

import arttab.server.vo.Attach;
import arttab.server.vo.Bid;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
public class ArtDetailDto {

  private int artNo;  // 작품번호
  private String artTitle;  // 작품명
  private String artCategory; // 작품구분 ex) 동양화:E, 서양화:W, 공예품:P
  private String artWriter;  // 작가
  private String artContent; // 작품설명
  private String artDetail; // 작품상세설명
  private int startPrice; // 경매시작가
  private int buyNowPrice; // 즉시구매가
  private int bidPricePer; // 입찰가격단위
  private Timestamp startDatetime; // 경매시작일시
  private Timestamp endDatetime; // 경매종료일시
  private Timestamp artRegDatetime; // 작품등록일시
  private String artStatus; // 작품경매현황 ex) Y:낙찰 건, P:경매진행중인 건, R:경매준비중인 건, F:경매종료 건, D:삭제처리 건

  private int maxBidPrice;
  private int nextBidPrice;
  private int memberNo;
}
