package arttab.server.Auth.mapper;

import arttab.server.Auth.vo.Member;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);  // Changed method name to insertMember
    List<Member> findAll();
    Member findBy(int memberNo);
    Member findByEmailAndPassword(@RequestParam("memberEmail") String memberEmail, @RequestParam("memberPwd") String memberPwd);
    String findPasswordByEmail(String memberEmail);
    void update(Member member);
    int delete(int memberNo);
}
