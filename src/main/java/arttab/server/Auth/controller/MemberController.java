package arttab.server.Auth.controller;

import arttab.server.Auth.vo.Member;
import arttab.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    MemberService memberService;

//    @Autowired
//    NcpObjectStorageService ncpObjectStorageService;

    @GetMapping("/signup")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(Member member, MultipartFile photofile) throws  Exception {
        System.out.println(member);
        memberService.add(member);
        return "redirect:list";
    }

    @GetMapping("delete")
    public String delete(int memberNo) throws Exception {
        if (memberService.delete(memberNo) == 0) {
            throw new Exception("해당 번호의 회원이 없습니다.");
        } else {
            return "redirect:list";
        }
    }

    @GetMapping("{memberNo}")
    public String detail(@PathVariable int memberNo, Model model) throws Exception {
        model.addAttribute("member", memberService.get(memberNo));
        return "member/detail";
    }

    @GetMapping("list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", memberService.list());
    }
}
