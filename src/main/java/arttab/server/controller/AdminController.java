package arttab.server.controller;


import arttab.server.service.AdminService;
import arttab.server.service.BidService;
import arttab.server.service.FAQService;
import arttab.server.service.NcpObjectStorageService;

import arttab.server.vo.*;

import arttab.server.service.ArtService;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  ArtService artService;
  @Autowired
  AdminService adminService;
  @Autowired
  BidService bidService;
  @Autowired
  FAQService faqService;
  @Autowired
  NcpObjectStorageService ncpObjectStorageService;

  private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    //admin

  @GetMapping("/main")
  public String admin() {
    log.info("Call main.html");
    return "/admin/main";
  }

    //faq

  @GetMapping("/faqform")
  public String faqform(Model model, HttpSession session) {
    log.info("Call admin/faqform.html");
      Member loginUser = (Member) session.getAttribute("loginUser");
      model.addAttribute("loginUser", loginUser);
    return "/admin/faqform";
  }

  @PostMapping("/addfaq")
  public String addfaq(FAQ faq, Model model, HttpSession session) throws Exception {
    log.info("addfaq");
      Member loginUser = (Member) session.getAttribute("loginUser");
      model.addAttribute("loginUser", loginUser);
        faqService.add(faq);
        return "redirect:/admin/faqlist";
    }

  @GetMapping("faqlist")
  public void faqlist(Model model) throws Exception {
    model.addAttribute("faqlist", faqService.list());
  }

  @PostMapping("/faqupdate")
  public String faqupdate(FAQ faq, Model model, HttpSession session) throws Exception {
    log.info("faqupdate");
    Member loginUser = (Member) session.getAttribute("loginUser");
    model.addAttribute("loginUser", loginUser);
    faqService.update(faq);
    return "redirect:/admin/faqlist";
  }

  @GetMapping("/faqdetail/{no}")
  public String faqdetail(@PathVariable int no, Model model) throws Exception {
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


    // art
    @GetMapping("/auction")
    public String auction() {
        log.info("Call admin/auction.html");
        return "/admin/auction";
    }

    @PostMapping("/addart")
    public String add(Art art, MultipartFile[] files, HttpSession session, @RequestParam("strStartDatetime") String strStartDatetime, @RequestParam("strEndDatetime") String strEndDatetime) throws Exception {
//    Member loginUser = (Member) session.getAttribute("loginUser");
//    if (loginUser == null) {
//      return "redirect:/auth/form";
//    }
        // 날짜 및 시간 문자열의 형식을 변경
        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedStartDatetime = targetFormat.format(sourceFormat.parse(strStartDatetime));
        String formattedEndDatetime = targetFormat.format(sourceFormat.parse(strEndDatetime));


        art.setStartDatetime(Timestamp.valueOf(formattedStartDatetime));
        art.setEndDatetime(Timestamp.valueOf(formattedEndDatetime));

        ArrayList<Attach> attaches = new ArrayList<>();
        for (MultipartFile part : files) {
            if (part.getSize() > 0) {
                Attach attach = ncpObjectStorageService.uploadFile(new Attach(),
                        "arttab-bucket", "art/", part);
                attaches.add(attach);
            }
        }
        art.setArtAttaches(attaches);

        adminService.add(art);

        return "redirect:/admin/artlist";
    }
    //작품 수정하기
    @PostMapping("/update")
    public String update(Art art, MultipartFile[] files, HttpSession session, @RequestParam("strStartDatetime") String strStartDatetime, @RequestParam("strEndDatetime") String strEndDatetime)  throws Exception {
        //Member loginUser = (Member) session.getAttribute("loginUser");
        //    Art a = artService.get(art.getArtNo());
        //**이미지 업로드
        //기존
//        art.setArtNo(artNo);
//        adminService.update(art);
//        return "redirect:../admin/artlist";

        // 날짜 및 시간 문자열의 형식을 변경
        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedStartDatetime = targetFormat.format(sourceFormat.parse(strStartDatetime));
        String formattedEndDatetime = targetFormat.format(sourceFormat.parse(strEndDatetime));


        art.setStartDatetime(Timestamp.valueOf(formattedStartDatetime));
        art.setEndDatetime(Timestamp.valueOf(formattedEndDatetime));

        ArrayList<Attach> attaches = new ArrayList<>();
        for (MultipartFile part : files) {
            if (part.getSize() > 0) {
                Attach attach = ncpObjectStorageService.uploadFile(new Attach(),
                        "arttab-bucket", "art/", part);
                attaches.add(attach);
            }
        }
        art.setArtAttaches(attaches);

        adminService.update(art);

        return "redirect:/admin/artlist";
    }

    @GetMapping("/artlist")
    public void artlist(Model model) throws Exception {
        model.addAttribute("artlist", adminService.list());
    }

    @GetMapping("/artdetail/{No}")
    public String artdetail(
            @PathVariable int No,
            Model model) throws Exception {

        model.addAttribute("art", adminService.get(No));
        System.out.println("Received request for art with no: " + No);
        System.out.printf(adminService.get(No).toString());


        return "admin/artdetail";
    }

    @GetMapping("delete") //작품삭제
    public String delete(@RequestParam ("artNo") int artNo) throws Exception {

        //로그인 정보 받기

        Art art = adminService.get(artNo);
        adminService.delete(art.getArtNo());
        return "redirect:../admin/artlist";
    }

    @GetMapping("fileDelete")
    public String fileDelete(
            @RequestParam("no") int no,
            HttpSession session) throws Exception {

//        Member loginUser = (Member) session.getAttribute("longinUser");
//        if (loginUser == null) {
//            return "redirect:/auth/form";
//        }

        Art art = null;

        Attach attach = adminService.getFile(no);
        art = adminService.get(attach.getArtNo());

        if (adminService.deleteFile(no) == 0) {
            throw new Exception("해당 번호의 첨부파일이 없습니다.");
        } else {
            return "redirect:/admin/artdetail/" + art.getArtNo();
        }
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

    //입찰현황
    @GetMapping("/bidstatus")
    public String bidstatus(Model model) throws Exception {
        log.info("Call /admin/bidstatus.html");

        List<Bid> bidStatusList = bidService.list();
        model.addAttribute("bidstatus", bidStatusList);

        log.info("bidstatus data: {}", bidStatusList);

        return "/admin/bidstatus";
    }
}
