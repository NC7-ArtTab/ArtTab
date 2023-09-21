//package arttab.server.controller;
//
//import arttab.server.service.ArtService;
//import arttab.server.service.BidService;
//import arttab.server.vo.Art;
//import arttab.server.vo.Bid;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin")
//@Slf4j
//public class AdminController {
//
//    @Autowired
//    private ArtService artService;
//
//    @Autowired
//    private BidService bidService;
//
//    @GetMapping("/main")
//    public String adminMain() {
//        log.info("Admin Main Page");
//        return "/admin/main";
//    }
//
//    @GetMapping("/faq")
//    public String adminFAQ() {
//        log.info("Admin FAQ Page");
//        return "/admin/faq";
//    }
//
//    @GetMapping("/faqform")
//    public String faqForm() {
//        log.info("FAQ Form Page");
//        return "/admin/faqform";
//    }
//
//    @GetMapping("/auction")
//    public String adminAuction() {
//        log.info("Admin Auction Page");
//        return "/admin/auction";
//    }
//
//    @PostMapping("/addart")
//    public String addArt(Art art, HttpSession session) throws Exception {
//        log.info("Add Art");
//        // 이미지 업로드 등의 작업 수행
//        artService.add(art);
//        return "redirect:/admin/main";
//    }
//
//    @GetMapping("/bidstatus")
//    public String bidStatus(Model model) throws Exception {
//        log.info("Bid Status Page");
//        List<Bid> bidStatusList = bidService.list();
//        model.addAttribute("bidstatus", bidStatusList);
//        return "/admin/bidstatus";
//    }
//}
