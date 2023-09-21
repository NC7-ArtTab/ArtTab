package arttab.server.dao;


import arttab.server.vo.FAQ;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface FAQDao {

    int insert(FAQ faq);

    List<FAQ> findAll();
    int update(FAQ faq);
    FAQ findBy(int no);
}
