package arttab.server.service;

import arttab.server.dao.MyPayDao;
import arttab.server.vo.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMyPayService implements MyPayService {
    private final MyPayDao myPayDao;

    @Autowired
    public DefaultMyPayService(MyPayDao myPayDao) {
        this.myPayDao = myPayDao;
    }

    @Override
    public List<Pay> getPurchaseHistory(int memberNo) {
        return myPayDao.getPurchaseHistory(memberNo);
    }
}
