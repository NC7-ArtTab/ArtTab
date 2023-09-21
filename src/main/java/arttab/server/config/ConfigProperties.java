package arttab.server.config;

import arttab.server.vo.SenderProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        SenderProperties.class
})
public class ConfigProperties {
}
