package arttab.server.service;

import arttab.server.dao.AdminDao;
import arttab.server.vo.Art;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultAdminService implements AdminService {


    AdminDao adminDao;

    public DefaultAdminService(AdminDao adminDao) {this.adminDao = adminDao;}

    @Transactional
    @Override
    public int update(Art art) throws Exception {
        return adminDao.update(art);
    }

    @Override
    public List<Art> searchlist(String option, String keyword) throws Exception {
        return adminDao.searchlist(option, keyword);
    }

    @Transactional
    @Override
    public int add(Art art) throws Exception {
        int count = adminDao.insert(art);
        if (art.getArtAttaches().size() > 0) {
            adminDao.insertFiles(art);
        }
        return count;
    }

    @Transactional
    @Override
    public int delete(int artNo) throws Exception {
        return adminDao.delete(artNo);
    }


    @Override
    public List<Art> list() throws Exception {
        return adminDao.findAll();
    }
}

