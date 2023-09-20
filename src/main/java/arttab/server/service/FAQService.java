package arttab.server.service;

import arttab.server.vo.Art;
import arttab.server.vo.FAQ;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FAQService {


    int add(FAQ faq) throws Exception;
    List<FAQ> list() throws Exception;
}