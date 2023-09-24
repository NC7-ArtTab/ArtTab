package arttab.server.controller;

import arttab.server.service.MemberService;
import arttab.server.service.MyBidService;
import arttab.server.service.MyPayService;
import arttab.server.vo.Member;
import arttab.server.vo.Bid;
import arttab.server.vo.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

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
    public String showProfileForm(Model model,  Member loginUser) throws Exception {
        model.addAttribute("member", loginUser);
        return "mypage/profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("member") Member updatedMember,Member loginUser) {
        try {
            // 로그인한 사용자의 memberNo 설정
            updatedMember.setMemberNo(loginUser.getMemberNo());

            // 멤버 정보 업데이트
            memberService.updateMember(updatedMember);

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
