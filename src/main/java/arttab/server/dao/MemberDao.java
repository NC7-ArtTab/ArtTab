package arttab.server.dao;

import arttab.server.vo.Member;

public interface MemberDao {
    void updateMember(Member member);
    Member findBy(int memNo); // 회원 번호로 회원 정보 조회
}
