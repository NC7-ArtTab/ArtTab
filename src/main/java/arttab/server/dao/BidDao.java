package arttab.server.dao;

import arttab.server.vo.Art;
import arttab.server.vo.Bid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BidDao {


    //List<Bid> searchlist(@Param("option") String option, @Param("keyword") String keyword);

    List<Bid> findAll();
}