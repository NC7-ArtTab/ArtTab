package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.dao.BidDao;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultBidService implements BidService {

    BidDao bidDao;

    public DefaultBidService(BidDao bidDao) {
        this.bidDao = bidDao;
    }



    public List<Bid> list() throws Exception {
        return bidDao.findAll();
    }

}