// DefaultMyBidService.java
package arttab.server.service;

import arttab.server.dao.MyBidDao;
import arttab.server.vo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMyBidService implements MyBidService {
    private final MyBidDao myBidDao;

    @Autowired
    public DefaultMyBidService(MyBidDao myBidDao) {
        this.myBidDao = myBidDao;
    }

    @Override
    public List<Bid> getMyBidList(int memNo) {
        return myBidDao.getMyBidList(memNo);
    }
}
