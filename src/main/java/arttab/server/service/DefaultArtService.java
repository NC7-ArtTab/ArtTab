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

  @Override
  public Art get(int artNo) throws Exception {
    return artDao.findBy(artNo);
  }

  @Transactional
  @Override
  public int update(Art art) throws Exception {
    System.out.println(art.toString() + "dkdkdk");
    int count = artDao.update(art);
//    if (count > 0 && art.getArtAttaches().size() > 0) {
//      artDao.insertFiles(art);
//    }

    System.out.println(count + "dkdkdk");
    return count;
  }

  @Transactional
  @Override
  public void delete(int artNo) throws Exception {
    artDao.delete(artNo);


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

  @Override
  public int update(Art art) throws Exception {
    return artDao.update(art);

  }

}
