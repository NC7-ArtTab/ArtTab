package arttab.server.controller;

import arttab.server.service.DefaultArtService;
import arttab.server.vo.Art;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/art")
public class ArtController {

    @Autowired
    DefaultArtService artService;


    @GetMapping("list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", artService.list());
    }

    @GetMapping("searchlist")
    public String searchlist(Model model, HttpSession session, @RequestParam String option, @RequestParam String keyword) throws Exception {

        model.addAttribute("option", option);
        model.addAttribute("keyword", keyword);

        List<Art> searchResult = artService.searchlist(option, keyword);
        model.addAttribute("searchResult", searchResult);
        System.out.println("Search List: " + searchResult);

        return "art/searchlist";
    }

}
