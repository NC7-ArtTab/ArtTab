package arttab.server.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SocialTokenDto {
private String access_Token;
private String token_type;
private String refresh_Token;
private Integer expires_in;
private String scope;
private Integer refresh_token_expires_in;
}
