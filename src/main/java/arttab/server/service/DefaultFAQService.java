package arttab.server.service;

import arttab.server.dao.FAQDao;
import arttab.server.vo.FAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFAQService implements FAQService {
    private final FAQDao faqDao;

    @Autowired
    public DefaultFAQService(FAQDao faqDao) {
        this.faqDao = faqDao;
    }

    @Override
    public List<FAQ> getAllFAQs() {
        return faqDao.getAllFAQs();
    }

    @Override
    public void addFAQ(String faqTitle, String faqContent) {
        // 새 FAQ 객체 생성
        FAQ newFAQ = new FAQ();
        newFAQ.setFaqTitle(faqTitle);
        newFAQ.setFaqContent(faqContent);
        newFAQ.setMemNo(1); // 회원번호를 기본값 1로 설정

        // faqDao를 사용하여 데이터베이스에 FAQ 추가
        faqDao.addFAQ(newFAQ);
    }
}
