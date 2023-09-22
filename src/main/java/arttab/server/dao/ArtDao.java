package arttab.server.dao;

import arttab.server.vo.Art;
import org.apache.ibatis.annotations.Mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;



import java.util.List;

@Mapper
public interface ArtDao {

  
    List<Art> searchlist(@Param("option") String option, @Param("keyword") String keyword);



  int insert(Art art);

  List<Art> findAll();

  Art findBy(int artNo);

  int update(Art art);
 int updateCount(int artNo);

  int delete(int artNo);

int insertFiles(Art art);

int deleteFile(int fileNo);

 int deleteFiles(int artNo);

  List<Art> findAll(Art art);



}
