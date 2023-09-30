package arttab.server.controller;

import arttab.server.dto.ArtDetailDto;
import arttab.server.service.BidService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bid")
public class BidController {
  private final BidService bidService;

  @Autowired
  public BidController(BidService bidService) {
    this.bidService = bidService;
  }

  @GetMapping("/bid/{artNo}")
  public String getBidInfo(HttpSession session, @PathVariable int artNo, Model model) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");

    System.out.println(artNo + "불러옴");
    Art art = bidService.findArtInfo(artNo);
    model.addAttribute("art", art);
    Bid bid = bidService.findBidInfo(artNo);
    model.addAttribute("bid", bid);

    if (loginUser != null) {
      model.addAttribute("loginUser", loginUser);
    }
    return "bid/bid";
  }

  @ResponseBody
  @PostMapping("/insertBid")
  public void insertBid(HttpSession session, HttpServletResponse response, Bid bid) throws Exception {

    try {
      Member loginUser = (Member) session.getAttribute("loginUser");
      bid.setMemberNo(loginUser.getMemberNo());
      bidService.insertBid(bid);

      Map<String, Object> data = new HashMap<String, Object>();

      data.put("msg", "입찰에 성공하셨습니다!");
      Gson gson = new Gson();

      response.setContentType("application/json; charset=UTF-8");
      response.getWriter().print(gson.toJson(data));
    } catch (Exception e) {
      throw e;
    }
  }
}
