package towardssweetly.datascheduler.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FoodNtrIrdntInfoApiConfiguration {
    private final String serviceKey;
    private final String url;

    public FoodNtrIrdntInfoApiConfiguration(
            @Value("${api.foodNtrIrdntInfoService.service-key}")
            String serviceKey,
            @Value("${api.foodNtrIrdntInfoService.url}")
            String url
    ) {
        this.serviceKey = serviceKey;
        this.url = url;
    }
}
