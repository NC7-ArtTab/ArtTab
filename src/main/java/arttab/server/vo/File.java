package arttab.server.vo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class File implements Serializable {
    private static final long serialVersionUID = 1L;

    private int fileNo;  //  파일번호
    private int artNo;  //  작품번호
    private String filePath;  //  파일경로
    private String originFileName;  // 원래파일명
    private String saveFileName;  //  저장파일명
    private Timestamp fileRegDatetime;  //  파일등록일시
    private char fileStatus;  //  파일사용여부 => 사용중(게시건), N:미사용(삭제건)

}