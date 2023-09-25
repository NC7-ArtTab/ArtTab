package arttab.server.controller;

import arttab.server.service.MemberService;
import arttab.server.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public void signUpForm() {

    }

    @PostMapping("/signup")
    public String signUp(Member member, MultipartFile photofile) throws  Exception {
        log.error("Email:[{}], Password:[{}]", member.getMemberEmail(),member.getMemberPwd());
        memberService.add(member);
        return "redirect:form";
    }

    @GetMapping("delete")
    public String delete(int memberNo) throws Exception {
        if (memberService.delete(memberNo) == 0) {
            throw new Exception("해당 번호의 회원이 없습니다.");
        } else {
            return "redirect:index";
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
