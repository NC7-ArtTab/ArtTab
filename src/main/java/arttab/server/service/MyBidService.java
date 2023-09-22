// MyBidService.java
package arttab.server.service;

import arttab.server.vo.Bid;

import java.util.List;

public interface MyBidService {
    List<Bid> getMyBidList(int memberNo);
}
