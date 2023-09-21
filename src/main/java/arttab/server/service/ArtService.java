package arttab.server.service;

import arttab.server.vo.Art;

import java.util.List;

public interface ArtService {

  int add(Art art) throws Exception;

  List<Art> list() throws Exception;

  Art get(int artNo) throws Exception;

  int update(Art art) throws Exception;

  void delete(int artNo) throws Exception;



}
