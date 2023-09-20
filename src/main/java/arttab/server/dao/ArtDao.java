package arttab.server.dao;

import arttab.server.vo.Art;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArtDao {

    int insert(Art art);

    int insertFiles(Art art);
    List<Art> searchlist(@Param("option") String option, @Param("keyword") String keyword);

    List<Art> findAll();
}
