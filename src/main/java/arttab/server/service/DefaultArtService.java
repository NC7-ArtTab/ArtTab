package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.vo.Art;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultArtService implements ArtService {

  {
    System.out.println("DefaultArtService 생성됨!");
  }


  ArtDao artDao;

  public DefaultArtService(ArtDao artDao) {
    this.artDao = artDao;

  }

  @Override
  public Art get(int artNo) throws Exception {
    System.out.println(artDao.findBy(artNo));
    return artDao.findBy(artNo);
  }

  @Override
  public List<Art> list(Art art) throws Exception {
      return artDao.findAll(art);
    }

  @Override
  public Art art(int artNo) throws Exception {
    return artDao.findBy(artNo);
  }
}
