package co.com.bancolombia.consumer.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "adapter.restconsumer")
public class RestConsumerProperties {
    private String url;
    private int timeout;
}