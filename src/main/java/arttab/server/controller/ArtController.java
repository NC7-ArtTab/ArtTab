package arttab.server.controller;

import arttab.server.service.ArtService;
import arttab.server.service.DefaultArtService;
import arttab.server.vo.Art;
import arttab.server.vo.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/art")
public class ArtController {

  @Autowired
  ArtService artService;


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

    if (art != null) {
      model.addAttribute("art", art);
    }
    return "art/tdetail";
  }
}
