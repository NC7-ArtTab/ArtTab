package arttab.server.controller;


import arttab.server.service.AdminService;
import arttab.server.service.BidService;
import arttab.server.service.FAQService;

import arttab.server.vo.FAQ;

import arttab.server.service.ArtService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    ArtService artService;

    AdminService adminService;
    BidService bidService;
    FAQService faqService;

    public AdminController(ArtService artService, AdminService adminService, BidService bidService, FAQService faqService) {
        this.artService = artService;
        this.adminService = adminService;
        this.bidService = bidService;
        this.faqService = faqService;
    }

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    //admin

    @GetMapping("/main")
    public String admin() {
        log.info("Call main.html");
        return "/admin/main";
    }

    //faq

    @GetMapping("/faqform")
    public String faqform() {
        log.info("Call admin/faqform.html");
        return "/admin/faqform";
    }

    @PostMapping("/addfaq")
    public String addfaq(FAQ faq) throws Exception{
        log.info("addfaq");

        faqService.add(faq);
        return "redirect:/admin/main";
    }

    @GetMapping("faqlist")
    public void faqlist(Model model) throws Exception {
        model.addAttribute("faqlist", faqService.list());
    }

    @PostMapping("/faqupdate")
    public String faqupdate(FAQ faq) throws Exception{
        log.info("faqupdate");

        faqService.update(faq);
        return "redirect:/admin/faqlist";
    }

    @GetMapping("/faqdetail/{no}")
    public String faqdetail(@PathVariable int no, Model model) throws Exception{
        model.addAttribute("faq", faqService.get(no));
        System.out.println("Received request for faq with no: " + no);

        Object faqlistData = model.getAttribute("faqdetail");
        if (faqlistData != null) {
            // faqlistData를 로그에 출력하거나 원하는 대로 처리합니다.
            System.out.println("faq 데이터: " + faqlistData.toString());
        } else {
            System.out.println("faq 데이터가 모델에 없습니다.");
        }
        return "admin/faqdetail";
    }


    // 작품 관리
    @GetMapping("/artist")
    public void artlist(Model model) throws Exception {
        model.addAttribute("artlist", adminService.list());
    }

    @PostMapping("/addart")
    public String addart(Art art, HttpSession session) throws Exception{
        log.info("addart");
        //Member loginUser = (Member) session.getAttribute("loginUser");
        //**이미지 업로드
        adminService.add(art);
        return "redirect:/admin/main";
    }

    @GetMapping("/auction")
    public String auction() {
        log.info("Call admin/auction.html");
        return "/admin/auction";
    }

//작품 수정하기 체크
  @PostMapping("/update")
  public String update(Art art, @RequestParam ("artNo") int artNo) throws Exception {
    //Member loginUser = (Member) session.getAttribute("loginUser");
    //    Art a = artService.get(art.getArtNo());
    //**이미지 업로드
    art.setArtNo(artNo);

      adminService.update(art);
    return "redirect:../admin/main";
  }


    //입찰현황
    @GetMapping("/bidstatus")
    public String bidstatus(Model model) throws Exception {
        log.info("Call /admin/bidstatus.html");

        //model.addAttribute("bidstatus", bidService.list());

        List<Bid> bidStatusList = bidService.list();
        model.addAttribute("bidstatus", bidStatusList);

        log.info("bidstatus data: {}", bidStatusList);

        return "/admin/bidstatus";
    }




  @GetMapping("detail") //작품수정성주
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

  @GetMapping("delete") //작품삭제
  public String delete(Art art, @RequestParam ("artNo") int artNo) throws Exception {

    adminService.delete(artNo);
    return "redirect:../admin/main";
  }

    @PostMapping("/add")
    public String add(Art art) throws Exception {
        //Member loginUser = (Member) session.getAttribute("loginUser");

        //**이미지 업로드

        adminService.add(art);
        return "redirect:/admin/main";
    }


    @GetMapping("/searchlist")
    public String searchlist(Model model, HttpSession session, @RequestParam String option, @RequestParam String keyword) throws Exception {

        model.addAttribute("option", option);
        model.addAttribute("keyword", keyword);

        System.out.println(option + " " + keyword);

        List<Art> searchResult = adminService.searchlist(option, keyword);
        model.addAttribute("searchResult", searchResult);
        System.out.println("Search List: " + searchResult);

        return "admin/searchlist";
    }

}
