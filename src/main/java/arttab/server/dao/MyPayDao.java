package arttab.server.dao;

import arttab.server.vo.Pay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyPayDao {
    List<Pay> getPurchaseHistory(@Param("memberNo") int memberNo);
}
