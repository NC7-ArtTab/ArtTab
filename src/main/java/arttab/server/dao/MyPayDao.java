package arttab.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import arttab.server.vo.Pay;

@Mapper
public interface MyPayDao {
    List<Pay> getPurchaseHistory(@Param("memNo") int memNo);
}
