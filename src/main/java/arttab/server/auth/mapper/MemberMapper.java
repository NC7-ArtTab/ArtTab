package arttab.server.auth.mapper;

import arttab.server.auth.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  // 로그인
  Member getMemberAccount(String memEmail);

  // 회원가입
  void saveMember(Member member);
}