package arttab.server.service.Member;

import arttab.server.Auth.mapper.MemberMapper;
import arttab.server.Auth.vo.Member;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class MemberService {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    private final MemberMapper memberMapper;

    @Transactional
    public void joinMember(Member member) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
        member.setMemberAuth("M");
        member.setCreatedDate(Timestamp.valueOf(localTime));
        member.setMemberStatus("Y");
        memberMapper.saveMember(member);
    }
}
