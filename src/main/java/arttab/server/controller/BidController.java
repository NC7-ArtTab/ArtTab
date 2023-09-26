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

  @GetMapping("/bid/{artNo}")
  public String getBidInfo(@PathVariable(name="artNo") int artNo, Model model) throws Exception {
    System.out.println(artNo + "불러옴");
    Art art = bidService.findArtInfo(artNo);
    model.addAttribute("art", art);
    Bid bid = bidService.findBidInfo(artNo);
    model.addAttribute("bid", bid);
    return "bid/bid";
  }

  @PostMapping("/insertBid")
  public String insertBid(Bid bid) throws Exception {
    bidService.insertBid(bid);
    return "redirect:/bid";
  }
}
