package arttab.server.service;

import arttab.server.dao.MyBidDao;
import arttab.server.vo.MyBid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultMyBidService implements MyBidService {

    private MyBidDao myBidDao;

    @Autowired
    public DefaultMyBidService(MyBidDao myBidDao) {
        this.myBidDao = myBidDao;
    }

    @Override
    @Transactional
    public List<MyBid> findByMemNo(int memNo) {
        return myBidDao.findByMemNo(memNo);
    }
}
