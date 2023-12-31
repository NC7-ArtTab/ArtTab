package arttab.server.vo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FAQ implements Serializable {

    private static final long serialVersionUID = 1L;

    private int faqNo;  //  faq번호
    private int memberNo;  //  회원번호
    private String faqTitle;  //  faq제목
    private String faqContent;  // faq내용
    private String faqWriter;  //  faq작성자
    private Timestamp faqRegDatetime;  //  faq등록일시
    private char faqStatus;  //  faq사용여부 => Y:사용중(게시중), N:미사용(삭제건)


}