package arttab.server.service;

import arttab.server.vo.Art;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

public interface ArtService {


  int add(Art art) throws Exception;

  List<Art> list() throws Exception;

  Art get(int artNo) throws Exception;

  int update(Art art) throws Exception;

  void delete(int artNo) throws Exception;

  List<Art> searchlist(String option, String keyword) throws Exception;



 


}

