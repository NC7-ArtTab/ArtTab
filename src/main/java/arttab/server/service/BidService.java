package arttab.server.service;

import arttab.server.vo.Bid;
import arttab.server.vo.FAQ;

import java.util.List;

public interface BidService {

    List<Bid> list() throws Exception;
}