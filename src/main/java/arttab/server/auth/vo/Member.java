package arttab.server.auth.vo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;

@Data
public class Member implements UserDetails {

  private int memNo;  //  회원번호
  private String memEmail;  //  이메일
  private String memPwd;  //  비밀번호
  private String memName;  //  이름
  private String memPhone;  //  휴대폰
  private String memZipcode;  //  우편번호
  private String memAddr;  //  기본주소
  private String memDetailAddr;  //  상세주소
  private String memBank;  //  은행명
  private String memAcc;  //  계좌번호
  private String memAuth;  //  회원권한 => A:관리자, M:일반회원
  private Timestamp memDatetime;  // 회원등록일시
  private char memStatus;  //  사용여부 => Y:회원, N:탈퇴회원

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority(this.memAuth));
  }

  @Override
  public String getPassword() {
    return this.memPwd;
  }

  // 시큐리티의 userName
  // -> 따라서 얘는 인증할 때 id를 봄
  @Override
  public String getUsername() {
    return this.memEmail;
  }

  // Vo의 userName !
  public String getUserName(){
    return this.memName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}