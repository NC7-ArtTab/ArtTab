package arttab.server.service;

import arttab.server.dao.ArtDao;
import arttab.server.vo.Art;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//        if (art.getAttachedFiles().size() > 0) {
//            artDao.insertFiles(art);
//        }
        return count;
    }

    public List<Art> list() throws Exception {
        return artDao.findAll();
    }

    public List<Art> searchlist(String option, String keyword) throws Exception {
        return artDao.searchlist(option, keyword);
    }
}