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

import javax.servlet.http.HttpSession;
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
    public String showProfileForm(Model model, HttpSession session) {

        Member loginUser = (Member) session.getAttribute("loginUser");

        // 로그인한 사용자 정보를 이용하여 프로필 페이지를 보여줌
        model.addAttribute("loginUser", loginUser);
        return "mypage/profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("member") Member updatedMember, HttpSession session) {
        try {
            // 세션에서 로그인한 사용자 정보를 가져옴
            Member loginUser = (Member) session.getAttribute("loginUser");

            // 로그인한 사용자의 memberNo 설정
            updatedMember.setMemberNo(loginUser.getMemberNo());

            // 멤버 정보 업데이트
            memberService.updateMember(updatedMember);

            return "redirect:/profile?success=true";
        } catch (Exception e) {

            return "redirect:/profile?error=true";
        }
    }


    @GetMapping("/mybid")
    public String showMyBids(Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옴
        Member loginUser = (Member) session.getAttribute("loginUser");

        // 로그인한 사용자의 멤버 번호를 추출
        int loggedInMemberNo = loginUser.getMemberNo();

        log.error("멤버 번호 추출>>> {}",loginUser.getMemberNo());
        // 해당 멤버 번호를 기반으로 입찰 정보를 가져옴
        List<Bid> myBidList = myBidService.getMyBidList(loggedInMemberNo);

        log.error("입찰 목록 가져오기>>{}",  myBidService.getMyBidList(loggedInMemberNo));

        // 입찰 정보를 모델에 추가하여 뷰로 전달
        model.addAttribute("myBidList", myBidList);

        log.error("뷰로 전달");

        return "mypage/mybid";
    }


    @GetMapping("/mypay")
    public String showMyPay(Model model, HttpSession session) {
        // 세션에서 로그인한 사용자 정보를 가져옴
        Member loginUser = (Member) session.getAttribute("loginUser");

        // 로그인한 사용자의 멤버 번호를 추출
        int loggedInMemberNo = loginUser.getMemberNo();

        log.error("멤버 번호 추출>>> {}",loginUser.getMemberNo());
        // 해당 멤버 번호를 기반으로 입찰 정보를 가져옴
        List<Pay> myPayList = myPayService.getPurchaseHistory(loggedInMemberNo);

        log.error("구매 목록 가져오기>>{}",  myPayService.getPurchaseHistory(loggedInMemberNo));

        // 입찰 정보를 모델에 추가하여 뷰로 전달
        model.addAttribute("myPayList", myPayList);

        log.error("뷰로 전달");

        return "mypage/mypay";
    }
}
