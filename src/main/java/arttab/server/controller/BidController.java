package arttab.server.controller;

import arttab.server.dto.ArtDetailDto;
import arttab.server.service.BidService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bid")
public class BidController {
  private final BidService bidService;

  @Autowired
  public BidController(BidService bidService) {
    this.bidService = bidService;
  }

//  @GetMapping("/art/{artNo}")
//  public String getArtInfo(@PathVariable int artNo, Model model) throws Exception {
//    try {
//
//      Art art = bidService.findArtInfo(artNo);
//
//      model.addAttribute("art", art);
//
//      return "bid/bid";
//
//    } catch (Exception e) {
//      throw e;
//    }
//  }

  @GetMapping("bid/{artNo}")
  public String getBidInfo(@PathVariable(required = true) int artNo, Model model) throws Exception {
    try {

      // 숫자로 변환 가능한 경우에만 실행
      ArtDetailDto artDto = bidService.findArtInfo(artNo);
      model.addAttribute("art", artDto);

      return "bid/bid";
    } catch (NumberFormatException e) {
      // artNo가 숫자로 변환 불가능한 경우에 대한 처리 (예: 예외 처리)
      // 예를 들어, 유효하지 않은 artNo에 대한 오류 페이지를 표시하거나 리디렉션을 수행할 수 있습니다.
      return "error"; // 또는 다른 적절한 처리 방법을 선택하세요.
    }
  }

  @PostMapping("/insertBid")
  public String insertBid(Bid bid) throws Exception {
    bidService.insertBid(bid);
    return "redirect:/bid";
  }
}
