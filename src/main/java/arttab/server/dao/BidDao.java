package arttab.server.dao;

import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BidDao {
  // 경매 상품 상세 정보 조회
  Art artDetail(int artNo);

  // 현재까지의 입찰 순위 조회
  List<Bid> bidRank(int artNo);

  // 입찰하기
  void insertBid(Bid bid);
}
