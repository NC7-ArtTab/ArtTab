package arttab.server.service;

import arttab.server.dao.BidDao;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBidService implements BidService {
  private final BidDao bidDao;

  @Autowired
  public DefaultBidService(BidDao bidDao) {
    this.bidDao = bidDao;
  }

  @Override
  public Art artDetail(int artNo) {
    return bidDao.artDetail(artNo);
  }

  @Override
  public List<Bid> bidRank(int artNo) {
    return bidDao.bidRank(artNo);
  }

  @Override
  public void insertBid(Bid bid) {
    bidDao.insertBid(bid);
  }
}
