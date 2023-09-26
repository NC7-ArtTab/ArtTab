package arttab.server.controller;

import arttab.server.service.KakaoLoginService;
import arttab.server.service.MemberService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class KakaoLoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/oauth/kakao")
    public String kakaoCallback(@RequestParam String code, HttpServletRequest request) {
        log.info(code);
        try {
            String access_Token = KakaoLoginService.getKaKaoAccessToken(code);
            KakaoLoginService.createKakaoUser(access_Token, request, memberService);
            log.info("Kakao callback code: {}", code);
            return "redirect:/";
        } catch (Exception e) {
            log.error("Exception occurred: {}", e.getMessage(), e);
        }
        return "redirect:form";
    }
}
