package arttab.server.controller;

import arttab.server.service.ArtService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/art")
public class ArtController {

  @Autowired
  ArtService artService;

  @PostMapping("/add")
  public String add(Art art) throws Exception{
    //Member loginUser = (Member) session.getAttribute("loginUser");

    //**이미지 업로드

    artService.add(art);
    return "redirect:/admin/main";
  }

  @GetMapping("/list")
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

  @PostMapping("/update")
  public String update(Art art, @RequestParam ("artNo") int artNo) throws Exception {
    //Member loginUser = (Member) session.getAttribute("loginUser");
    //    Art a = artService.get(art.getArtNo());
    //**이미지 업로드
    art.setArtNo(artNo);

    artService.update(art);
    return "redirect:../admin/main";
  }


}
