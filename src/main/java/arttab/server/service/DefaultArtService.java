package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.vo.Art;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class DefaultArtService implements ArtService {



ArtDao artDao;

  public DefaultArtService(ArtDao artDao) {
    this.artDao = artDao;
  }

  public List<Art> searchlist(String option, String keyword) throws Exception {
     return artDao.searchlist(option, keyword);
    }

  @Transactional
  @Override
  public int add(Art art) throws Exception{
    int count = artDao.insert(art);
    //사진 추가
//        if (art.getAttaches().size() > 0) {
//            artDao.insertFiles(art);
//        }
    return count;
  }

  @Override
  public List<Art> list() throws Exception {
    return artDao.findAll();
  }


  @Transactional
  @Override
  public void delete(int artNo) throws Exception {
    artDao.delete(artNo);
  }

  @Override
  public Art get(int artNo) throws Exception {
    return artDao.findBy(artNo);
  }

  @Transactional
  @Override
  public int update(Art art) throws Exception {
    return artDao.update(art);
  }



  //성주
  public List<Art> list(Art art) throws Exception {
    return artDao.findAll(art);
  }

}
