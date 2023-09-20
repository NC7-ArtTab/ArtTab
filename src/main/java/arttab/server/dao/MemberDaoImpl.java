package arttab.server.dao;

import org.springframework.stereotype.Repository;
import arttab.server.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Repository
public class MemberDaoImpl implements MemberDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void updateMember(Member member) {
        String sql = "UPDATE member " +
                "SET mem_name = ?, mem_phone = ?, mem_addr = ?, mem_detail_addr = ?, mem_acc = ? " +
                "WHERE mem_no = ?";

        jdbcTemplate.update(sql,
                member.getMemName(),
                member.getMemPhone(),
                member.getMemAddr(),
                member.getMemDetailAddr(),
                member.getMemAcc(),
                member.getMemNo());
    }

    @Override
    public Member findBy(int memNo) {
        String sql = "SELECT * FROM member WHERE mem_no = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
            Member member = new Member();
            member.setMemNo(resultSet.getInt("mem_no"));
            member.setMemName(resultSet.getString("mem_name"));
            member.setMemPhone(resultSet.getString("mem_phone"));
            member.setMemAddr(resultSet.getString("mem_addr"));
            member.setMemDetailAddr(resultSet.getString("mem_detail_addr"));
            member.setMemAcc(resultSet.getString("mem_acc"));
            return member;
        }, memNo);
    }
}
