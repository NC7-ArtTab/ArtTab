package arttab.server.vo;

import lombok.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private Timestamp memberDatetime;  // 회원등록일시
    private String memberStatus;
    private List<Bid> memberBids;
}