package towardssweetly.datascheduler.infra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import towardssweetly.datascheduler.config.FoodNtrIrdntInfoApiConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FoodNtrIrdntInfoServiceTest {
    @Autowired
    FoodNtrIrdntInfoApiConfiguration configuration;

    @Autowired
    private FoodNtrIrdntInfoService foodNtrIrdntInfoService;

    @Test
    @DisplayName("https://apis.data.go.kr 주소에 실제 데이터를 요청한다.")
    void getFoodNtrIrdntInfoResponseTest() {
        final var json = "json";
        final var pageNo = 1;
        final var numOfRows = 10;
        final var response = foodNtrIrdntInfoService.getFoodNtrIrdntInfoResponse(pageNo, numOfRows, json);
        assertThat(response.getBody().getItems().size()).isEqualTo(numOfRows);
    }
}
