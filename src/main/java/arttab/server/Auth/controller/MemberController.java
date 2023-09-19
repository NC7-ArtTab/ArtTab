package arttab.server.Auth.controller;

import arttab.server.Auth.vo.Member;
import arttab.server.service.Member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/signup")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(Member member) {
        memberService.joinMember(member);
        return "redirect:/login";
    }
}
