package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.vo.Art;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultArtService implements ArtService {
  {
    System.out.println("실행됨!!");
  }

ArtDao artDao;

  public DefaultArtService(ArtDao artDao) {
    this.artDao = artDao;
  }

  @Override
  public List<Art> list() throws Exception {
    return artDao.findAll();
  }

  @Override
  public Art get(int artNo) {
    System.out.println(artDao.findBy(artNo));
    return artDao.findBy(artNo);
  }


}
