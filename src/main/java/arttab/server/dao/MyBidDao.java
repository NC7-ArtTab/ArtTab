// MyBidMapper.java
package arttab.server.dao;

import arttab.server.vo.Bid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface MyBidDao {
    List<Bid> getMyBidList(@Param("memberNo") int memberNo);
}
