package arttab.server.controller;

import arttab.server.dto.ArtDetailDto;
import arttab.server.service.BidService;
import arttab.server.vo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bid")
public class BidController {
  private final BidService bidService;

  @Autowired
  public BidController(BidService bidService) {
    this.bidService = bidService;
  }

  @GetMapping("/art/{artNo}")
  public ArtDetailDto artDetail(@PathVariable int artNo) {
    return bidService.artDetail(artNo);
  }

  @GetMapping("/bidRank/{artNo}")
  public List<Bid> bidRank(@PathVariable int artNo) {
    return bidService.bidRank(artNo);
  }

  @PostMapping("/bid")
  public void insertBid(@RequestBody Bid bid) {
    bidService.insertBid(bid);
  }

}
