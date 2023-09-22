package arttab.server.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자 생성

@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 생성
public class Attach implements Serializable {
  private static final long serialVersionUID = 1L;

  private int fileNo;  //  파일번호
  private int artNo;  //  작품번호
  private String filePath;  //  파일경로
  private String originFileName;  // 원래파일명
  private String saveFileName;  //  저장파일명
  private Timestamp fileRegDatetime;  //  파일등록일시

  private String fileStatus;  //  파일사용여부 => 사용중(게시건), N:미사용(삭제건)


}