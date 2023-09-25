package arttab.server.dao;

import arttab.server.vo.Art;
import arttab.server.vo.SearchParam;
import org.apache.ibatis.annotations.Mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;



import java.util.List;

@Mapper
public interface ArtDao {

  Art findBy(int artNo);

  int update(Art art);

  List<Art> findAll(Art art);

  List<Art> searchedList(SearchParam searchParam);
}
