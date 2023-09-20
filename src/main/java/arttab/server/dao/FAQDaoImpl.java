package arttab.server.dao;

import arttab.server.vo.FAQ;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FAQDaoImpl implements FAQDao {

    private final SqlSession sqlSession;

    public FAQDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<FAQ> getAllFAQs() {
        return sqlSession.selectList("arttab.server.dao.FAQDao.selectAllFAQs");
    }

    @Override
    public FAQ getFAQById(Long faqNo) {
        return sqlSession.selectOne("arttab.server.dao.FAQDao.selectFAQById", faqNo);
    }
}
