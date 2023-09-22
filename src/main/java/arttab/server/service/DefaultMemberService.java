package arttab.server.service;


import arttab.server.Auth.mapper.MemberMapper;
import arttab.server.Auth.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {

  private final MemberMapper memberMapper;
  private final PasswordEncoder passwordEncoder;


  @Transactional
  @Override
  public void add(Member member) throws Exception {
    if (!member.getMemberName().equals("") && !member.getMemberEmail().equals("")) {
      // password는 암호화해서 DB에 저장
      member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
      memberMapper.insertMember(member);
    }
  }

  @Override
  public List<Member> list() throws Exception {
    return memberMapper.findAll();
  }

  @Override
  public Member get(int memberNo) throws Exception {
    return memberMapper.findBy(memberNo);
  }

  @Override
  public Member get(String memberEmail, String memberPwd) throws Exception {
    return memberMapper.findByEmailAndPassword(memberEmail, memberPwd);
  }

  @Override
  public String getEncryptPassword(String password) {
    return passwordEncoder.encode(password);
  }

  @Transactional
  @Override
  public void update(Member member) {
    member.setMemberPwd(getEncryptPassword(member.getMemberPwd()));
    memberMapper.update(member);
  }

  @Override
  public String findPasswordByEmail(String memberEmail) {
    return memberMapper.findPasswordByEmail(memberEmail);
  }

  @Transactional
  @Override
  public int delete(int memberNo) throws Exception {
    return memberMapper.delete(memberNo);
  }
}
