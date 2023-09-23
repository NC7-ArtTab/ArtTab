package arttab.server.service;

import arttab.server.dao.AdminDao;
import arttab.server.vo.Art;
import arttab.server.vo.Attach;
import jdk.jshell.spi.ExecutionControlProvider;
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
        int count = adminDao.update(art);
        if (count > 0 && art.getArtAttaches().size() > 0) {
            adminDao.insertFiles(art);
        }
        return count;
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

    @Override
    public Art get(int artNo) throws Exception {
        return adminDao.findBy(artNo);
    }

    @Transactional
    @Override
    public Attach getFile(int fileNo) throws Exception {
        return adminDao.findAttach(fileNo);
    }
}

