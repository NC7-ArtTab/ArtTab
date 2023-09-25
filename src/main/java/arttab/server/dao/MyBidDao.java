package arttab.server.dao;

import arttab.server.vo.Bid;

import java.util.List;

public interface MyBidDao {
    List<Bid> getMyBidList(int memberNo);
}
