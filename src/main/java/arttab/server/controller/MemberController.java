package arttab.server.controller;

import arttab.server.auth.vo.Member;
import arttab.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  /**
   * localhost:8080 시 login 으로 redirect
   * @ return
   */
  @GetMapping
  public String root() {
    return "redirect:/login";
  }

  /**
   * 로그인 폼
   * @ return
   */
  @GetMapping("/login")
  public String login(){
    return "index";
  }

  /**
   * 회원가입 폼
   * @ return
   */
  @GetMapping("/signup")
  public String signUpForm() {
    return "signup";
  }

  /**
   * 로그인 실패 폼
   * @ return
   */
  @GetMapping("/asset_denied")
  public String accessDenied() {
    return "asset_denied";
  }

  /**
   * 회원가입 진행
   * @param member
   * @ return
   */
  @PostMapping("/signup")
  public String signUp(Member member) {
    memberService.joinMember(member);
    return "redirect:/index"; //로그인 구현 예정
  }

  /**
   * 유저 페이지
   * @param model
   * @param authentication
   * @ return
   */
  @GetMapping("/member_access")
  public String memAccess(Model model, Authentication authentication) {
    //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
    Member member = (Member) authentication.getPrincipal();  //userDetail 객체를 가져옴
    model.addAttribute("info", member.getMemEmail() +"의 "+ member.getMemName()+ "님");      //유저 아이디
    return "member_access";
  }
}