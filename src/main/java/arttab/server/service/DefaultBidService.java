package arttab.server.service;

import arttab.server.dao.BidDao;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultBidService implements BidService {

  private final BidDao bidDao;

  @Autowired
  public DefaultBidService(BidDao bidDao) {
    this.bidDao = bidDao;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Member> getMemberWithBids(int memNo) {
    return bidDao.memberWithBids(memNo);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Art> getArtWithBids(int artNo) {
    return bidDao.artWithBids(artNo);
  }

  @Override
  @Transactional
  public void insertBid(Bid bid) {
    bidDao.insertBid(bid);
  }
}
