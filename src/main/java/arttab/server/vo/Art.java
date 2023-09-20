package arttab.server.vo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor // 기본생성자 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 생성
public class Art implements Serializable {
  private static final long serialVersionUID = 1L;

  private int artNo;  // 작품번호
  private String artTitle;  // 작품명
  private char artCategory;   // 작품구분 ex) 동양화:E, 서양화:W, 공예품:P
  private String artWriter; // 작가
  private String artContent;  // 작품설명
  private String artDetail; // 작품상세설명
  private int startPrice; // 경매시작가
  private int buyNowPrice;  // 즉시구매가
  private int bidPricePer;  // 입찰가격단위
  private Timestamp startDatetime;  //  경매시작일시
  private Timestamp endDatetime;  // 경매종료일시
  private Timestamp artRegDatetime; // 작품등록일시
  private char artStatus; // 작품경매현황 ex) Y:낙찰 건, P:경매진행중인 건, R:경매준비중인 건, F:경매종료 건

  private List<Attach> artAttaches; // 작품 첨부파일 목록
  private List<Bid> artBids;  // 작품 입찰가 목록

  public int getArtNo() {
    return artNo;
  }

  public void setArtNo(int artNo) {
    this.artNo = artNo;
  }

  public String getArtTitle() {
    return artTitle;
  }

  public void setArtTitle(String artTitle) {
    this.artTitle = artTitle;
  }

  public char getArtCategory() {
    return artCategory;
  }

  public void setArtCategory(char artCategory) {
    this.artCategory = artCategory;
  }

  public String getArtWriter() {
    return artWriter;
  }

  public void setArtWriter(String artWriter) {
    this.artWriter = artWriter;
  }

  public String getArtContent() {
    return artContent;
  }

  public void setArtContent(String artContent) {
    this.artContent = artContent;
  }

  public String getArtDetail() {
    return artDetail;
  }

  public void setArtDetail(String artDetail) {
    this.artDetail = artDetail;
  }

  public int getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(int startPrice) {
    this.startPrice = startPrice;
  }

  public int getBuyNowPrice() {
    return buyNowPrice;
  }

  public void setBuyNowPrice(int buyNowPrice) {
    this.buyNowPrice = buyNowPrice;
  }

  public int getBidPricePer() {
    return bidPricePer;
  }

  public void setBidPricePer(int bidPricePer) {
    this.bidPricePer = bidPricePer;
  }

  public Timestamp getStartDatetime() {
    return startDatetime;
  }

  public void setStartDatetime(Timestamp startDatetime) {
    this.startDatetime = startDatetime;
  }

  public Timestamp getEndDatetime() {
    return endDatetime;
  }

  public void setEndDatetime(Timestamp endDatetime) {
    this.endDatetime = endDatetime;
  }

  public Timestamp getArtRegDatetime() {
    return artRegDatetime;
  }

  public void setArtRegDatetime(Timestamp artRegDatetime) {
    this.artRegDatetime = artRegDatetime;
  }

  public char getArtStatus() {
    return artStatus;
  }

  public void setArtStatus(char artStatus) {
    this.artStatus = artStatus;
  }

  public List<Attach> getArtaAttaches() {
    return artAttaches;
  }

  public void setArtFiles(List<Attach> artAttaches) {
    this.artAttaches = artAttaches;
  }

  public List<Bid> getArtBids() {
    return artBids;
  }

  public void setArtBids(List<Bid> artBids) {
    this.artBids = artBids;
  }
}
