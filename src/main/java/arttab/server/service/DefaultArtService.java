package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.vo.Art;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


  @Transactional
  @Override
  public int add(Art art) throws Exception{
    int count = artDao.insert(art);
    //사진 추가
//        if (art.getAttachedFiles().size() > 0) {
//            artDao.insertFiles(art);
//        }
    return count;
  }

  @Override
  public List<Art> list() throws Exception {
    return artDao.findAll();
  }

  @Override
  public Art get(int artNo) throws Exception {
    return artDao.findBy(artNo);
  }


}
