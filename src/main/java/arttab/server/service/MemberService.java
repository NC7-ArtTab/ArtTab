package arttab.server.service;

import arttab.server.Auth.vo.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    String getEncryptPassword(String password);
    void add(Member member) throws Exception;
    List<Member> list() throws Exception;
    Member get(int memberNo) throws Exception;
    Member get(String memberEmail, String memberPwd) throws Exception;
    void update(Member member) throws Exception;

    String findPasswordByEmail(String memberEmail);

    int delete(int memberNo) throws Exception;
}
