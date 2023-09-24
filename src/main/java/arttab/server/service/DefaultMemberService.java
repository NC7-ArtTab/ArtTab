package arttab.server.service;

import arttab.server.dao.MemberDao;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {

  @Autowired
  private final MemberDao memberDao;
  @Autowired
  private final PasswordEncoder passwordEncoder;

  @Transactional
  @Override
  public void add(Member member) throws Exception {
    if (!member.getMemberName().equals("") && !member.getMemberEmail().equals("")) {
      // password는 암호화해서 DB에 저장
      String encryptedPassword = passwordEncoder.encode(member.getMemberPwd());
      member.setMemberPwd(encryptedPassword);  // 한 번만 암호화된 비밀번호를 저장
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
    member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
    memberDao.updateMember(member);
  }

  @Override
  public String findPasswordByEmail(String memberEmail) throws Exception {
    return memberDao.findPasswordByEmail(memberEmail);
  }

  @Transactional
  @Override
  public int delete(int memberNo) throws Exception {
    return memberDao.delete(memberNo);
  }

  @Override
  public List<Bid> getMemberBids(int memberNo) throws Exception {
    return memberDao.getMemberBids(memberNo);
  }

  @Override
  public Member findBy(int memberNo) throws Exception {
    return memberDao.findBy(memberNo);
  }
}