package arttab.server.controller;

import arttab.server.service.ArtService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/art")
public class ArtController {

  @Autowired
  ArtService artService;

  @GetMapping("auction")
  public String auction() throws Exception {
    return "art/auction";
  }

  @PostMapping("/add")
  public String add(Art art) throws Exception{
    //Member loginUser = (Member) session.getAttribute("loginUser");

    //**이미지 업로드

    artService.add(art);
    return "redirect:/art/list";
  }

  @GetMapping("list")
  public String list(Model model) throws Exception {
    model.addAttribute("list", artService.list());
    return "art/list";
  }

  @GetMapping("detail/{artNo}")
  public String detail(
          @PathVariable int artNo,
          Model model) throws Exception {

    Art art = artService.get(artNo);
    List<Bid> list = art.getArtBids();

    if (art != null) {
      model.addAttribute("art", art);
      model.addAttribute("list", list);
    }
    return "art/tdetail";
  }
}
