package arttab.server.service;

import arttab.server.vo.Art;

import java.util.List;

public interface ArtService {

    int add(Art art) throws Exception;
    List<Art> list() throws Exception;
}