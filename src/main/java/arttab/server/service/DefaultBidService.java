package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.dao.BidDao;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import arttab.server.dto.ArtDetailDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class DefaultBidService implements BidService {
  BidDao bidDao;

  @Autowired
  public DefaultBidService(BidDao bidDao) {
    this.bidDao = bidDao;
  }

  public List<Bid> list() throws Exception {
    return bidDao.findAll();
  }

  @Override
  public ArtDetailDto findArtInfo(int artNo) {
    return bidDao.artInfo(artNo);
  }

  @Override
  public ArtDetailDto findBidInfo(int artNo) {
    return bidDao.bidInfo(artNo);
  }

  @Override
  public void insertBid(Bid bid) {
    bidDao.insertBid(bid);
  }
}
