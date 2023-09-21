package arttab.server.dao;

import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface MemberDao {
    void updateMember(Member member);
    Member findBy(int memNo); // 회원 번호로 회원 정보 조회

    List<Bid> getMemberBids(int memNo);
}
