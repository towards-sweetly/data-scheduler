package towardssweetly.datascheduler.config;

import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * {@link org.springframework.web.client.RestTemplate} 을 사용할 때,ConnectTimeout 과 ReadTimeout 을 설정해 병목 현상 빈도를 최소화한다.
 */
@Configuration(proxyBeanMethods = false)
public class RestTemplateBuilderConfiguration {
    @Bean
    public RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
        return configurer.configure(new RestTemplateBuilder())
                .setConnectTimeout(Duration.ofSeconds(7))
                .setReadTimeout(Duration.ofSeconds(4));
    }
}
