package arttab.server.controller;

import arttab.server.service.ArtService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.PageNation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/art")
public class ArtController {


  {
    System.out.println("ArtController 생성됨");
  }

  @Autowired
  ArtService artService;

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
    return "art/detail";
  }
  @GetMapping("list")
  public String list(Model model,
                     @RequestParam(name="pageNo", defaultValue = "1") int pageNo,
                     @RequestParam(name="artStatus", defaultValue = "") String artStatus,
                     @RequestParam(name="artCategory", defaultValue = "") String artCategory) throws Exception {

    try {
      Art art = new Art();
      art.setArtCategory(artCategory);
      art.setArtStatus(artStatus);

      List<Art> artList = artService.list(art); // artCategory와 artStatus를 담아 넘김

      if (artList != null && artList.size() > 0) { // 조회된 전체 경매작품이 0 개 이상이면
        PageNation pageNation = new PageNation(pageNo);
        List<Art> subList = pageNation.toSubList(artList, pageNo);  // 현재 요청된 페이지에 보여줄 게시글만 subList로 추출

        int totalPages = pageNation.setGetTotalPages(artList.size());
        int startPage = pageNation.setGetStartPage(pageNo);
        pageNation.setGetEndPage(startPage, totalPages);

        model.addAttribute("pageNation", pageNation);
        model.addAttribute("list", subList);
      }
      model.addAttribute("artCategory", art.getArtCategory());
      model.addAttribute("artStatus", art.getArtStatus());
      return "art/list";

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @GetMapping("detail")
  public String list(Model model,
                     @RequestParam(name = "artNo", defaultValue = "1") int artNo) throws Exception {

    Art art = artService.art(artNo);
    System.out.println(art.toString() + "------------------");
    System.out.println(art.toString());

    return "list";


  }
}