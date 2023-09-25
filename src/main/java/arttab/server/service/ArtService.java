package arttab.server.service;

import arttab.server.vo.Art;
import arttab.server.vo.SearchParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

public interface ArtService {
  Art get(int artNo) throws Exception;
  List<Art> list(Art art) throws Exception;
  List<Art> searchedList(SearchParam searchParam) throws  Exception;
  int update(Art art) throws Exception;
}

