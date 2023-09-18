package arttab.server.controller;

import arttab.server.service.DefaultArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/art")
public class ArtController {

  @Autowired
  DefaultArtService artService;


  @GetMapping("list")
  public void list(Model model) throws Exception {
    model.addAttribute("list", artService.list());
  }

}
