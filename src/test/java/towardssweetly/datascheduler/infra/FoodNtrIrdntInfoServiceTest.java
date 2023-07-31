package towardssweetly.datascheduler.infra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

class FoodNtrIrdntInfoServiceTest {
    private static final String SERVICE_KEY = "1cM0fca7x9v9lVDH7x/Ys0Sg9uzmVsLqRY/yRtnbxpefDmZHVQf2zdR768cNW8Qrx5GlwWK0RyMa2ekGH4bJSg==";
    private final FoodNtrIrdntInfoService foodNtrIrdntInfoService = new FoodNtrIrdntInfoService(new RestTemplateBuilder());

    @Test
    @DisplayName("https://apis.data.go.kr 주소에 실제 데이터를 요청한다.")
    void getDataTest() {
        final String json = "json";
        final int pageNo = 1;
        final int numOfRows = 10;
        var response = foodNtrIrdntInfoService.getData(pageNo, numOfRows, json, SERVICE_KEY);
        Assertions.assertThat(response.getBody().getItems().size()).isEqualTo(numOfRows);
    }
}
