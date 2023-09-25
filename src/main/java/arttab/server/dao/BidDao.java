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

  ArtDetailDto artInfo(int artNo);

  ArtDetailDto bidInfo(int artNo);

  // 입찰하기
  void insertBid(Bid bid);

//  List<Art> findAll(Art art);
//
}
