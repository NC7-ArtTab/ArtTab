package arttab.server.controller;

import arttab.server.service.MemberService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import arttab.server.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AuthController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/form")
    public String form(@CookieValue(required = false) String memberEmail, Model model) {
        model.addAttribute("memberEmail", memberEmail);
        return "/form";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("memberEmail") String memberEmail,
            @RequestParam("memberPwd") String memberPwd,
            HttpSession session,
            Model model,
            HttpServletResponse response) throws Exception {
        if (memberEmail != null && !memberEmail.isEmpty()) {  // null 또는 비어 있는지 확인
            Cookie cookie = new Cookie("memberEmail", memberEmail);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("memberEmail", "");  // 빈 문자열로 설정
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        Member loginUser = memberService.get(memberEmail, memberService.getEncryptPassword(memberPwd));
        log.error("사용자 정보는 있나? >>> {}", loginUser.toString());
        log.error("동일 한가 ? >>>{}}" , passwordEncoder.matches(memberPwd, loginUser.getMemberPwd()));
        if (!passwordEncoder.matches(memberPwd, loginUser.getMemberPwd())) {
            model.addAttribute("refresh", "2;url=/form");
            throw new Exception("회원 정보가 일치하지 않습니다.");
        }

        session.setAttribute("loginUser", loginUser);
        log.info("Call login");
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        log.info("Call logout");
        return "redirect:/";
    }
}