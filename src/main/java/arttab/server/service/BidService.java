package arttab.server.service;

import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;

import java.util.List;

public interface BidService {
  Art artDetail(int artNo);
  List<Bid> bidRank(int artNo);
  void insertBid(Bid bid);
}