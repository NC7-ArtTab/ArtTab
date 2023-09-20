package arttab.server.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@Data
@ConstructorBinding
@ToString
public class PageNation {
  public static final int PAGE_PER_ART_CNT = 6; // 페이지 당 보여줄 작품 수
  public static final int PAGE_BTN_COUNT = 5; // 선택할 수 있는 페이징 버튼 수

  private int pageNo; // 현재 페이지 번호
  private int endRow; // 현재 페이지에 보여줄 마지막 경매작품 행
  private int totalPages; // 전체 페이지 개수
  private int startPage; // 시작 페이지 번호
  private int endPage; // 끝 페이지 번호
  private List<Art> subList; // 전체 경매작품 중 현재 요청받은 페이지에만 보여질 경매작품 리스트


  public PageNation(int pageNo) {
    this.pageNo = pageNo;
  }

  // 전체 게시글 중 보여질 게시글 리스트 리턴
  public List<Art> toSubList(List<Art> artList, int pageNo) {
    if (artList.size() >= ((pageNo - 1) * PAGE_PER_ART_CNT) + PAGE_PER_ART_CNT) {
      endRow = PAGE_PER_ART_CNT;
    } else {
      endRow = artList.size() - ((pageNo - 1) * PAGE_PER_ART_CNT);
    }
    subList = artList.subList((pageNo - 1) * PAGE_PER_ART_CNT, (pageNo - 1) * PAGE_PER_ART_CNT + endRow);

    return subList;
  }

  // 총 페이지 수 계산 = 총 작품 개수(삭제건 제외) /  페이지 당 작품 수 => 반환
  public int setGetTotalPages(int listSize) {
    totalPages = listSize % PAGE_PER_ART_CNT > 0 ? (listSize / PageNation.PAGE_PER_ART_CNT) + 1 : listSize / PAGE_PER_ART_CNT;
    return totalPages;
  }

  // 시작 페이지(startPage) 계산후 반환
  public int setGetStartPage(int pageNo) {
    startPage = pageNo / PAGE_BTN_COUNT * PAGE_BTN_COUNT + 1;

    // 시작 페이지 보정
    if (pageNo % PAGE_BTN_COUNT == 0) {
      startPage -= PAGE_BTN_COUNT;
    }
    return startPage;
  }

  // 종료 페이지(endPage) 계산 후 반환
  public int setGetEndPage(int startPage, int totalPages) {
    endPage = startPage + (PAGE_BTN_COUNT - 1);

    if(endPage > totalPages) {
      endPage = totalPages;
    }
    return endPage;
  }
}
