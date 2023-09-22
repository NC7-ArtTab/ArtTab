package arttab.server.service;
import arttab.server.vo.Bid;
import arttab.server.vo.Member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//@Service
public interface MemberService {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    List<Bid> getMemberBids(int memberNo) throws Exception;
    void updateMember(Member member) throws Exception;
    Member findBy(int memberNo) throws Exception; // 멤버 번호로 멤버 정보 조회!
    String getEncryptPassword(String password);
    void add(Member member) throws Exception;
    List<Member> list() throws Exception;
    Member get(int memberNo) throws Exception;
    Member get(String memberEmail, String memberPwd) throws Exception;

    String findPasswordByEmail(String memberEmail) throws Exception;

    int delete(int memberNo) throws Exception;

}
