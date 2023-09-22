package arttab.server.service;


import arttab.server.dao.MemberDao;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {



  MemberDao memberDao;
  PasswordEncoder passwordEncoder;


  public DefaultMemberService(MemberDao memberDao, PasswordEncoder passwordEncoder) {
    this.memberDao = memberDao;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  @Override
  public void add(Member member) throws Exception {
    if (!member.getMemberName().equals("") && !member.getMemberEmail().equals("")) {
      // password는 암호화해서 DB에 저장
      member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
      memberDao.insertMember(member);
    }
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  @Override
  public Member get(int memberNo) throws Exception {
    return memberDao.findBy(memberNo);
  }

  @Override
  public Member get(String memberEmail, String memberPwd) throws Exception {
    return memberDao.findByEmailAndPassword(memberEmail, memberPwd);
  }

  @Override
  public String getEncryptPassword(String password) {
    return passwordEncoder.encode(password);
  }



  @Transactional
  @Override
  public void updateMember(Member member) throws Exception {
    member.setMemberPwd(getEncryptPassword(member.getMemberPwd()));
    memberDao.updateMember(member);
  }

  @Override
  public String findPasswordByEmail(String memberEmail) throws Exception{
    return memberDao.findPasswordByEmail(memberEmail);
  }

  @Transactional
  @Override
  public int delete(int memberNo) throws Exception {
    return memberDao.delete(memberNo);
  }

  @Override
  public List<Bid> getMemberBids(int memberNo) throws Exception {
    return null;
  }

  @Override
  public Member findBy(int memberNo) throws Exception {
    return null;
  }
}
