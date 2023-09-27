package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.vo.Art;


import arttab.server.vo.SearchParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class DefaultArtService implements ArtService {

  ArtDao artDao;

  public DefaultArtService(ArtDao artDao) {this.artDao = artDao;}


  public List<Art> list(Art art) throws Exception {
      return artDao.findAll(art);
  }

  @Override
  public List<Art> searchedList(SearchParam searchParam) throws Exception {
    return artDao.searchedList(searchParam);
  }

  @Override
  public Art get(int artNo) throws Exception {
    return artDao.findBy(artNo);
  }

  @Override
  public int update(Art art) throws Exception {
    return artDao.update(art);
  }

  @Override
  public void updateStatus(int artNo) throws Exception {
    artDao.updateStatus(artNo);
  }
}
