package arttab.server.vo;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchParam {
  private String searchType;
  private String searchKeyword;

}
