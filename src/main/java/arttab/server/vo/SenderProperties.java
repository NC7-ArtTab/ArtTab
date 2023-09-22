package arttab.server.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ToString
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "sender")
public class SenderProperties {
  private String user;
  private String password;
}
