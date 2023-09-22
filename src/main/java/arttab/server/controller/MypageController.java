package arttab.server.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Slf4j
@Controller
@RequestMapping("/mypage")
public class MypageController {

    //mypage
    @GetMapping("/main")
    public String mypage() {
        log.info("Call mypage.html");
        return "/mypage/main";
    }

    @GetMapping("/modification")
    public String modification() {
        log.info("Call modification.html");
        return "/mypage/modification";
    }
}
