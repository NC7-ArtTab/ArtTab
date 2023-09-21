package arttab.server.service;


import arttab.server.Auth.mapper.MemberMapper;
import arttab.server.Auth.vo.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultMemberService implements MemberService {

  MemberMapper memberMapper;

  public DefaultMemberService(MemberMapper memberMapper) {
    this.memberMapper = memberMapper;
  }

  @Transactional
  @Override
  public void add(Member member) throws Exception {
    memberMapper.insertMember(member);
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

  @Transactional
  @Override
  public int update(Member member) throws Exception {
    return memberMapper.update(member);
  }

  @Transactional
  @Override
  public int delete(int memberNo) throws Exception {
    return memberMapper.delete(memberNo);
  }
}
