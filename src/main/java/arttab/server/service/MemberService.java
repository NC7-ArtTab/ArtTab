package arttab.server.service;

import arttab.server.auth.mapper.MemberMapper;
import arttab.server.auth.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
  // 회원가입 시 저장시간을 넣어줄 DateTime형
  SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
  Date time = new Date();
  String localTime = format.format(time);

  final MemberMapper memberMapper;


  @Transactional
  public void joinMember(Member member){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    member.setMemPwd(passwordEncoder.encode(member.getMemPwd()));
    member.setMemAuth("USER");
    member.setMemDatetime(Timestamp.valueOf(localTime));
    memberMapper.saveMember(member);
  }

  @Override
  public Member loadUserByUsername(String memEmail) throws UsernameNotFoundException {
    //여기서 받은 유저 패스워드와 비교하여 로그인 인증
    Member member = memberMapper.getMemberAccount(memEmail);
    if (member == null){
      throw new UsernameNotFoundException("User not authorized.");
    }
    return member;
  }
}
