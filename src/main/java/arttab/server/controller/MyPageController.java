package arttab.server.controller;

import arttab.server.service.MemberService;
import arttab.server.service.MyBidService;
import arttab.server.service.MyPayService;
import arttab.server.vo.Member;
import arttab.server.vo.Bid;
import arttab.server.vo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mypage")
public class MyPageController {

    private final MemberService memberService;
    private final MyBidService myBidService;
    private final MyPayService myPayService;

    @Autowired
    public MyPageController(MemberService memberService, MyBidService myBidService, MyPayService myPayService) {
        this.memberService = memberService;
        this.myBidService = myBidService;
        this.myPayService = myPayService;
    }

    @GetMapping("/main")
    public String mypage() {
        log.info("Call mypage.html");
        return "mypage/main";
    }

    @GetMapping("/profile")
    public String showProfileForm(Model model) throws Exception {
        int loggedInMemberNo = 5; // 가정한 멤버 번호

        Member member = memberService.get(loggedInMemberNo);

        model.addAttribute("member", member);

        return "mypage/profile";
    }

    // 프로필 수정 폼에서 데이터를 받아서 처리
    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("member") Member member) {
        try {
            int loggedInMemberNo = 5; // 가정한 멤버 번호
            member.setMemberNo(loggedInMemberNo);

            memberService.updateMember(member);
            return "redirect:/mypage/profile?success=true";
        } catch (Exception e) {
            return "redirect:/mypage/profile?error=true";
        }
    }

    @GetMapping("/mybid")
    public String showMyBids(Model model) {
        int loggedInMemberNo = 5; // 가정한 멤버 번호

        List<Bid> myBidList = myBidService.getMyBidList(loggedInMemberNo);

        model.addAttribute("myBidList", myBidList);

        return "mypage/mybid";
    }

    @GetMapping("/mypay")
    public String showMyPay(Model model) {
        int loggedInMemberNo = 5; // 가정한 멤버 번호

        List<Pay> myPayList = myPayService.getPurchaseHistory(loggedInMemberNo);

        model.addAttribute("myPayList", myPayList);

        return "mypage/mypay";
    }
}
