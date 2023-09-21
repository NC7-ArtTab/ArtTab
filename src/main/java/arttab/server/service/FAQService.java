package arttab.server.service;

import arttab.server.vo.FAQ;

import java.util.List;

public interface FAQService {

    int add(FAQ faq) throws Exception;
    List<FAQ> list() throws Exception;

    int update(FAQ faq) throws Exception;
    FAQ get(int faqNo) throws Exception;
}