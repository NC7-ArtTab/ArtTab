package arttab.server.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자 생성
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private int memNo;  //  회원번호
    private String memEmail;  //  이메일
    private String memPwd;  //  비밀번호
    private String memName;  //  이름
    private String memPhone;  //  휴대폰
    private String memZipcode;  //  우편번호
    private String memAddr;  //  기본주소
    private String memDetailAddr;  //  상세주소
    private String memBank;  //  은행명
    private String memAcc;  //  계좌번호
    private char memAuth;  //  회원권한 => A:관리자, M:일반회원
    private Timestamp memDatetime;  // 회원등록일시
    private char memStatus;  //  사용여부 => Y:회원, N:탈퇴회원

}