package arttab.server.service;

import arttab.server.vo.Art;

import java.util.List;

public interface ArtService {

  List<Art> list() throws Exception;
}
