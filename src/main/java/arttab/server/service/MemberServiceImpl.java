package arttab.server.service;

import arttab.server.dao.MemberDao;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDao memberDao;

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

    @Override
    public List<Bid> getMemberBids(int memNo) {
        return memberDao.getMemberBids(memNo);
    }
}
