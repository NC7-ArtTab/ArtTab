package arttab.server.dao;

import arttab.server.vo.MyBid;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyBidDao {
    List<MyBid> findByMemNo(int memNo);
}
