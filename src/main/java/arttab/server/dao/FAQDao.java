package arttab.server.dao;

import arttab.server.vo.Art;
import arttab.server.vo.FAQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FAQDao {

    int insert(FAQ faq);
    List<FAQ> findAll();
}
