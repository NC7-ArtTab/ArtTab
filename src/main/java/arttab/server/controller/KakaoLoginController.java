package arttab.server.controller;

import arttab.server.service.KakaoLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class KakaoLoginController {

    @ResponseBody
    @GetMapping("/oauth/kakao")
    public void kakaoCallback(@RequestParam String code) {
        log.info(code);
        try {
            String access_Token = KakaoLoginService.getKaKaoAccessToken(code);
            KakaoLoginService.createKakaoUser(access_Token);
            log.info("Kakao callback code: {}", code);

        } catch (Exception e) {
            log.error("Exception occurred: {}", e.getMessage(), e);
        }
    }
}
