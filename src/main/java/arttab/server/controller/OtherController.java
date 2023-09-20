package arttab.server.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/other")
public class OtherController {


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
}
