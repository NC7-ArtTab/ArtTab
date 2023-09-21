package arttab.server.dao;

import arttab.server.vo.Art;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface ArtDao {
  List<Art> findAll(Art art);
  Art findBy(int artNo);
  int update(Art art);

}

