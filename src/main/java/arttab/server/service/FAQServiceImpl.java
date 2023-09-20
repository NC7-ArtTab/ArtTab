package arttab.server.service;

import arttab.server.dao.FAQDao;
import arttab.server.vo.FAQ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQServiceImpl implements FAQService {

    private final FAQDao faqDao;

    public FAQServiceImpl(FAQDao faqDao) {
        this.faqDao = faqDao;
    }

    @Override
    public List<FAQ> getAllFAQs() {
        return faqDao.getAllFAQs();
    }

    @Override
    public FAQ getFAQById(Long faqNo) {
        return faqDao.getFAQById(faqNo);
    }
}
