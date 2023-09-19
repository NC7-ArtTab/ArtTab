package arttab.server.Auth.mapper;

import arttab.server.Auth.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void saveMember(Member member);
}
