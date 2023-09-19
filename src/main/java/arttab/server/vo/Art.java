package arttab.server.vo;

import lombok.*;


import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 생성
public class Art implements Serializable {
    private static final long serialVersionUID = 1L;

    private String art_no;
    private String art_title;
    private String writer;
    private String art_content;
    private String art_detail;

    private String option;
    private String keyword;

}
