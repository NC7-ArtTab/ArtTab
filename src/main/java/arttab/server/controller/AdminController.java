package arttab.server.controller;


import arttab.server.service.ArtService;
import arttab.server.service.BidService;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ArtService artService;
    @Autowired
    BidService bidService;
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    //admin

    @GetMapping("/main")
    public String admin() {
        log.info("Call main.html");
        return "/admin/main";
    }

    @GetMapping("/faq")
    public String adminfaq() {
        log.info("Call other/faq.html");
        return "/other/faq";
    }

    @GetMapping("/faqform")
    public String faqform() {
        log.info("Call admin/faqform.html");
        return "/admin/faqform";
    }

    @GetMapping("/auction")
    public String auction() {
        log.info("Call admin/auction.html");
        return "/admin/auction";
    }

    @PostMapping("/addart")
    public String addfaq(Art art, HttpSession session) throws Exception{
        log.info("addart");
        //Member loginUser = (Member) session.getAttribute("loginUser");

        //**이미지 업로드

        artService.add(art);
        return "redirect:/admin/main";
    }


    //입찰
    @GetMapping("/bidstatus")
    public String bidstatus(Model model) throws Exception {
        log.info("Call /admin/bidstatus.html");

        //model.addAttribute("bidstatus", bidService.list());

        List<Bid> bidStatusList = bidService.list();
        model.addAttribute("bidstatus", bidStatusList);

        log.info("bidstatus data: {}", bidStatusList);

        return "/admin/bidstatus";
    }



}
