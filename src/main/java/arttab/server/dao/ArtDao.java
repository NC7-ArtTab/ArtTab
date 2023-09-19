package arttab.server.dao;

import arttab.server.vo.Art;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtDao {

    List<Art> searchlist(String option, String keyword);

    List<Art> findAll();
}
