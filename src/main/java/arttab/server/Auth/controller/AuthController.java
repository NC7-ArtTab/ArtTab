package arttab.server.Auth.controller;

import arttab.server.Auth.vo.Member;
import arttab.server.service.MemberService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AuthController {

    @Autowired
    MemberService memberService;

    @GetMapping("/form")
    public void form(@CookieValue(required = false) String memberEmail, Model model) {
        model.addAttribute("memberEmail", memberEmail);
    }

    @PostMapping("/login")
    public String login(
            @RequestParam(name="memberEmail") String memberEmail,
            @RequestParam(name="memberPwd") String memberPwd,
            @RequestParam(name="saveEmail") String saveEmail,
            HttpSession session,
            Model model,
            HttpServletResponse response) throws Exception {

        if (saveEmail != null) {
            Cookie cookie = new Cookie("memberEmail", memberEmail);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("memberEmail", "memberNo");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        Member loginUser = memberService.get(memberEmail, memberPwd);
        log.info(loginUser.toString());
        if (loginUser == null) {
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