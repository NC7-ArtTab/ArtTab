package arttab.server;


import arttab.server.service.DefaultArtService;
import arttab.server.vo.Art;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Slf4j
@Controller
public class TestController {
    @GetMapping("/")
    public String index() {
        log.info("Call index.html");
        return "index";
    }
    @GetMapping("/layout-test")
    public String layoutTest() {
        log.info("Call test.html");
        return "test";
    }

    //other
    @GetMapping("/faq")
    public String faqTest() {
        log.info("Call faq.html");
        return "/other/faq";
    }

    @GetMapping("/rule")
    public String rule() {
        log.info("Call rule.html");
        return "/other/rule";
    }

    @GetMapping("/terms")
    public String terms() {
        log.info("Call terms.html");
        return "/other/terms";
    }

    @GetMapping("/intro")
    public String intro() {
        log.info("Call intro.html");
        return "/other/intro";
    }

    //mypage
    @GetMapping("/mypage")
    public String mypage() {
        log.info("Call mypage.html");
        return "/mypage/main";
    }

    @GetMapping("/modification")
    public String modification() {
        log.info("Call modification.html");
        return "/mypage/modification";
    }

    //admin

    @GetMapping("/admin")
    public String admin() {
        log.info("Call main.html");
        return "/admin/main";
    }

    @GetMapping("/admin/faq")
    public String adminfaq() {
        log.info("Call admin/faq.html");
        return "/admin/faq";
    }

    @GetMapping("/admin/auction")
    public String auction() {
        log.info("Call admin/auction.html");
        return "/admin/auction";
    }


    @GetMapping("/admin/bidstatus")
    public String bidstatus() {
        log.info("Call /admin/bidstatus.html");
        return "/admin/bidstatus";
    }
}
