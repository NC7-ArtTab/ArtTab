package arttab.server.controller;


import arttab.server.service.ArtService;
import arttab.server.service.FAQService;
import arttab.server.vo.FAQ;
import arttab.server.vo.Art;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    FAQService faqService;
    @Autowired
    ArtService artService;

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

    @PostMapping("/addfaq")
    public String addfaq(FAQ faq, HttpSession session) throws Exception{
        log.info("addfaq");
        //Member loginUser = (Member) session.getAttribute("loginUser");
        faqService.add(faq);
        return "redirect:/admin/main";
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
        artService.add(art);
        return "redirect:/admin/main";
    }


    @GetMapping("/bidstatus")
    public String bidstatus() {
        log.info("Call /admin/bidstatus.html");
        return "/admin/bidstatus";
    }
}
