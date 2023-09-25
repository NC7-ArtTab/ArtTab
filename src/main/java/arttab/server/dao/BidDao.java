package arttab.server.dao;

import arttab.server.dto.ArtDetailDto;
import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface BidDao {
  //List<Bid> searchlist(@Param("option") String option, @Param("keyword") String keyword);
  List<Bid> findAll();

  Art artInfo(int artNo);

  Bid bidInfo(int artNo);

  // 입찰하기
  void insertBid(Bid bid);

//  List<Art> findAll(Art art);
//
}
