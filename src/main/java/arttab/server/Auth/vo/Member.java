package arttab.server.Auth.vo;

import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
    private int memberNo;
    private String memberEmail;
    private String memberPwd;
    private String memberName;
    private String memberPhone;
    private String memberZipcode;
    private String memberAddr;
    private String memberDetailAddr;
    private String memberBank;
    private String memberAcc;
    private String memberAuth;
    private Timestamp createdDate;
    private String memberStatus;
    private String memberBack;
}
