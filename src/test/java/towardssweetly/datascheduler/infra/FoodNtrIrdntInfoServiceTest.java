package towardssweetly.datascheduler.infra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import static org.assertj.core.api.Assertions.*;

class FoodNtrIrdntInfoServiceTest {
    private static final String SERVICE_KEY = "1cM0fca7x9v9lVDH7x/Ys0Sg9uzmVsLqRY/yRtnbxpefDmZHVQf2zdR768cNW8Qrx5GlwWK0RyMa2ekGH4bJSg==";
    private final FoodNtrIrdntInfoService foodNtrIrdntInfoService = new FoodNtrIrdntInfoService(new RestTemplateBuilder());

    @Test
    @DisplayName("https://apis.data.go.kr 주소에 실제 데이터를 요청한다.")
    void getFoodNtrIrdntInfoResponseTest() {
        final var json = "json";
        final var pageNo = 1;
        final var numOfRows = 10;
        final var response = foodNtrIrdntInfoService.getFoodNtrIrdntInfoResponse(pageNo, numOfRows, json, SERVICE_KEY);
        assertThat(response.getBody().getItems().size()).isEqualTo(numOfRows);
    }
}
