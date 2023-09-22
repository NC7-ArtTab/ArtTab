package arttab.server.service;

import arttab.server.dto.ArtDetailDto;
import arttab.server.vo.Bid;

import java.util.List;

public interface BidService {
  // 경매 상품 상세 정보 조회
  ArtDetailDto artDetail(int artNo);

  // 현재까지의 입찰 순위 조회
  List<Bid> bidRank(int artNo);

  void insertBid(Bid bid);

}
