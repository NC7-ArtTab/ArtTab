package arttab.server.controller;

import arttab.server.service.BidService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

  BidService bidService;

  @Autowired
  public BidController(BidService bidService) {
    this.bidService = bidService;
  }

  // 특정 회원의 입찰 정보를 조회하는 엔드포인트
  @GetMapping("/members/{memNo}/bids")
  public List<Member> getMemberWithBids(@PathVariable int memNo) throws Exception {
    return bidService.getMemberWithBids(memNo);
  }

  // 특정 작품의 입찰 정보를 조회하는 엔드포인트
  @GetMapping("/arts/{artNo}/bids")
  public List<Art> getArtWithBids(@PathVariable int artNo) throws Exception {
    return bidService.getArtWithBids(artNo);
  }

  // 새로운 입찰 정보를 추가하는 엔드포인트
  @PostMapping("/bids")
  public void insertBid(@RequestBody Bid bid) throws Exception {
    bidService.insertBid(bid);
  }
}
