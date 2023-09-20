package arttab.server.service;

import arttab.server.dao.MemberDao;
import arttab.server.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    @Transactional
    public void updateMember(Member member) {
        memberDao.updateMember(member);
    }

    @Override
    @Transactional
    public Member findBy(int memNo) {
        return memberDao.findBy(memNo);
    }
}
