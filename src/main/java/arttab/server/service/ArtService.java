package arttab.server.service;

import arttab.server.vo.Art;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ArtService {
    List<Art> list(Art art) throws Exception;

    Art art(int artNo) throws Exception;
}
