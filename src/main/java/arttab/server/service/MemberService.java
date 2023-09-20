package arttab.server.service;

import arttab.server.vo.Bid;
import arttab.server.vo.Member;

import java.util.List;

public interface MemberService {
    void updateMember(Member member);
    Member findBy(int memNo); // 멤버 번호로 멤버 정보 조회!

    List<Bid> getMemberBids(int memNo);
}
