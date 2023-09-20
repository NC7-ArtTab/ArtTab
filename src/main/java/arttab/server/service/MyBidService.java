package arttab.server.service;

import arttab.server.vo.MyBid;

import java.util.List;

public interface MyBidService {
    List<MyBid> findByMemNo(int memNo);
}
