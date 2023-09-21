package arttab.server.Auth.mapper;

import arttab.server.Auth.vo.Member;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);  // Changed method name to insertMember
    List<Member> findAll();
    Member findBy(int memberNo);
    Member findByEmailAndPassword(@Param("memberEmail") String memberEmail, @Param("memberPwd") String memberPwd);
    int update(Member member);
    int delete(int memberNo);
}
