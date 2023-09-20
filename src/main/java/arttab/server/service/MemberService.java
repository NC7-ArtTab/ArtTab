package arttab.server.service;

import arttab.server.vo.Member;

public interface MemberService {
    void updateMember(Member member);
    Member findBy(int memNo); // 멤버 번호로 멤버 정보 조회!
}
