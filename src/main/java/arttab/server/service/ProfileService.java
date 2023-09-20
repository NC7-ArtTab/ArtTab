package arttab.server.service;

import arttab.server.dao.MemberDao;
import arttab.server.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {
    private final MemberDao memberDao;

    @Autowired
    public ProfileService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Transactional
    public Member getMemberByNo(int memNo) {
        // 회원 번호를 사용하여 회원 정보를 조회
        return memberDao.findBy(memNo);
    }

    @Transactional
    public void updateMember(Member member) {
        // 회원 정보를 업데이트
        memberDao.updateMember(member);
    }
}
