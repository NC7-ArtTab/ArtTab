package arttab.server.controller;

import arttab.server.service.ArtService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  ArtService artService;

  @GetMapping("main")
  public String main(Model model) throws Exception {
    model.addAttribute("list", artService.list());
    return "admin/main";
  }

  @GetMapping("auction")
  public String auction() throws Exception {
    return "admin/auction";
  }

  @GetMapping("detail")
  public String detail(
          @RequestParam int artNo,
          Model model) throws Exception {

    Art art = artService.get(artNo);
    List<Bid> list = art.getArtBids();

    if (art != null) {
      model.addAttribute("art", art);
      model.addAttribute("list", list);
    }
    return "admin/detail";
  }

  @GetMapping("delete")
  public String delete(Art art, @RequestParam ("artNo") int artNo) throws Exception {

    artService.delete(artNo);
    return "redirect:../admin/main";
  }

}
