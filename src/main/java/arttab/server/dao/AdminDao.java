package arttab.server.dao;

import arttab.server.vo.Art;
import arttab.server.vo.Attach;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AdminDao {


    int insertFiles(Art art) throws Exception;
    Attach findAttach(int no);
//    int deleteFile(int fileNo) throws Exception;
//
//    int deleteFiles(int artNo) throws Exception;

    int update(Art art) throws Exception;

    int add(Art art) throws Exception;

    int delete(int artNo) throws Exception;

    int insert(Art art) throws Exception;

    List<Art> findAll();

    List<Art> searchlist(@Param("option") String option, @Param("keyword") String keyword) throws Exception;

    Art findBy(int artNo);
    int deleteFile(int fileNo);
    int deleteFiles(int artNo);
}
