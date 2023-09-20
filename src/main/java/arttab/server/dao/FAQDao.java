package arttab.server.dao;

import arttab.server.vo.FAQ;

import java.util.List;

public interface FAQDao {
    List<FAQ> getAllFAQs();
    FAQ getFAQById(Long faqNo);
}
