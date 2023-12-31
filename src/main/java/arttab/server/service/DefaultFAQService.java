package arttab.server.service;


import arttab.server.dao.FAQDao;
import arttab.server.vo.FAQ;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultFAQService implements FAQService {

    FAQDao faqDao;

    public DefaultFAQService(FAQDao faqDao) {
        this.faqDao = faqDao;
    }
    
    @Transactional
    @Override
    public int add(FAQ faq) throws Exception{
        return faqDao.insert(faq);
    }

    @Override
    public List<FAQ> list() throws Exception {
        return faqDao.findAll();
    }

    @Transactional
    @Override
    public int update(FAQ faq) throws Exception {
        return faqDao.update(faq);
    }

    @Override
    public FAQ get(int faqNo) throws Exception {
        return faqDao.findBy(faqNo);
    }



}
