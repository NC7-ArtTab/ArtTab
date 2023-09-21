package arttab.server.dao;

import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BidDao {

  List<Member> memberWithBids(@Param("mem_no") int memNo);

  List<Art> artWithBids(@Param("art_no") int artNo);

  void insertBid(Bid bid);
}
