package arttab.server.controller;

import arttab.server.service.MemberService;
import arttab.server.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(Member member) {
        memberService.updateMember(member); // 회원 정보 수정 메서드 호출
        return "redirect:/login";
    }
}
