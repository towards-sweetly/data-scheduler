package towardssweetly.datascheduler.infra.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FoodNtrIrdntInfoResponse {
    private FoodNtrIrdntInfoResponseHeader header;
    private FoodNtrIrdntInfoResponseBody body;
}
