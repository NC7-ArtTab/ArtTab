package arttab.server.controller;

import arttab.server.service.MemberService;
import arttab.server.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class ProfileController {

    private final MemberService memberService;

    @GetMapping("/profile")
    public String showProfileForm(Model model) {
        // 여기에서 현재 멤버 정보를 데이터베이스에서 가져와서 모델에 추가하고 profile.html 템플릿으로 전달
        int memNo = 1; // 예시로 멤버 번호를 지정,로그인한 정보를 가져와야 함
        Member member = memberService.findBy(memNo);
        model.addAttribute("member", member);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(Member member) {
        System.out.println("업데이트");
        // 수정된 멤버 정보를 저장하는 서비스 호출
        memberService.updateMember(member);
        System.out.println("업데이트2");
        return "redirect:/mypage/profile";
    }
}