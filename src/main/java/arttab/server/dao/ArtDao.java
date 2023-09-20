package arttab.server.dao;

import arttab.server.vo.Art;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtDao {

  int insert(Art art);

  List<Art> findAll();

  Art findBy(int artNo);
//
//  int update(Art art);
//
//  int updateCount(int artNo);
//
//  int delete(int artNo);
//
//  int insertFiles(Art art);
//
//  int deleteFile(int fileNo);
//
//  int deleteFiles(int artNo);
}
