package arttab.server.controller;

import arttab.server.dto.PayDto;
import arttab.server.service.ArtService;
import arttab.server.service.MemberService;
import arttab.server.service.NcpObjectStorageService;
import arttab.server.service.PayService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import arttab.server.vo.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {

  @Autowired
  PayService payService;
  @Autowired
  MemberService memberService;
  @Autowired
  ArtService artService;

  @Autowired
  NcpObjectStorageService ncpObjectStorageService;

  @PostMapping("insertPay")
  public ResponseEntity<Map<String, Object>> add(
          @RequestParam("memberNo") int memberNo,
          @RequestParam("artNo") int artNo,
          @RequestParam("buyNowPrice") int buyNowPrice,

          HttpSession session
  ) throws Exception {

    Art art = artService.get(artNo);

    Member updateMember = memberService.get(memberNo);

    Member loginUser = (Member) session.getAttribute("loginUser");

    session.setAttribute("loginUser", updateMember);
    session.setAttribute("art", art);

    Pay pay = new Pay();
    pay.setMember(loginUser);
    pay.setArt(art);
    pay.setPayPrice(buyNowPrice);
    payService.add(pay);
    System.out.println("##############pay =   " + pay);

    // 응답 데이터 생성 및 반환
    Map<String, Object> response = new HashMap<>();
    response.put("memberNo", memberNo);
    response.put("artNo", artNo);
    response.put("buyNowPrice", buyNowPrice);

    return ResponseEntity.ok(response);
  }

//    // 현재 시간 구하기
//    LocalDateTime currentDatetime = LocalDateTime.now();
//
//    // endDatetime과 비교하여 payPrice 결정
//    if (currentDatetime.isAfter(payDto.getEndDatetime().toLocalDateTime())) {
//      // 현재 시간이 endDatetime 이후라면 bidPrice를 설정 (예: bidPrice를 내림차순으로 정렬했을 때 0번째 값 사용)
//      int bidPrice = getBidPriceForArt(artNo); // 아래에 정의된 메서드로 bidPrice를 가져옴
//      bid.setBidPrice(bidPrice);
//    } else {
//      // 현재 시간이 endDatetime 이전이라면 buyNowPrice를 설정 (예: artNo와 일치하는 buyNowPrice를 가져옴)
//      int buyNowPrice = getBuyNowPriceForArt(artNo); // 아래에 정의된 메서드로 buyNowPrice를 가져옴
//      pay.setPayPrice(buyNowPrice);
//    }
//  }

//  @GetMapping("/pay/{artNo}")
//  public String getArtDetail(@RequestParam("artNo") int artNo, Model model) throws Exception {
//    Art art = payService.payArtList(artNo); // getArtById는 ArtService의 메서드입니다.
//    if(art == null) {
//      // 적절한 에러 페이지를 리턴하거나, 로그를 남깁니다.
//      return "error";
//    }
//    model.addAttribute("art", art);
//    return "pay/pay"; // 여기서 artDetail은 뷰의 이름입니다 (예: artDetail.html)
//  }

  @GetMapping("/pay/{artNo}")
  public String getPayList(@PathVariable int artNo, Model model) {
    try {
      Pay pay = payService.list(artNo); // 서비스 호출
      if (pay != null) {
        model.addAttribute("pay", pay); // Model 객체에 Pay 객체를 추가
      }
      // 데이터가 없더라도 pay.html로 이동.
      // pay.html에서는 th:if="${pay != null}"와 같은 조건을 사용하여 데이터가 없을 때의 화면을 처리할 수 있습니다.
    } catch (Exception e) {
      e.printStackTrace(); // 로깅을 위한 콘솔 출력, 실제 프로덕션 코드에서는 Logger 사용을 권장합니다.
      // 에러 페이지로 리디렉션 또는 다른 에러 처리를 할 수 있습니다.
      // 예: return "error";
    }
    return "pay/pay"; // pay.html로 이동
  }

}
