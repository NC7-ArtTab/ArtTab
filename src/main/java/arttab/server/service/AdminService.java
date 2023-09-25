package arttab.server.service;

import arttab.server.vo.Art;

import java.util.List;

public interface AdminService {
    int add(Art art) throws Exception;

    List<Art> list() throws Exception;

    int update(Art art) throws Exception;

    int delete(int artNo) throws Exception;

//    List<Art> searchlist(String option, String keyword) throws Exception;
}
