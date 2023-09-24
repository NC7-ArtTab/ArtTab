package arttab.server.dao;

import java.util.List;
import arttab.server.vo.Member;
import arttab.server.vo.Bid;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface MemberDao {
    void insertMember(Member member);  // Changed method name to insertMember
    List<Member> findAll();
    List<Bid> getMemberBids(int memberNo);
    Member findBy(int memberNo);
    Member findByEmailAndPassword(@RequestParam("memberEmail") String memberEmail, @RequestParam("memberPwd") String memberPwd);
    String findPasswordByEmail(String memberEmail);
    void updateMember(Member member);
    int delete(int memberNo);
    int countByEmail(String email);
}
