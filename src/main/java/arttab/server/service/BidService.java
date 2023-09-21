package arttab.server.service;

import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;

import java.util.List;

public interface BidService {
  List<Member> getMemberWithBids(int memNo) throws Exception;

  List<Art> getArtWithBids(int artNo) throws Exception;

  void insertBid(Bid bid) throws Exception;
}
