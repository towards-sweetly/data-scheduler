package towardssweetly.datascheduler.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FoodNtrIrdntInfoResponse {
    @JsonProperty("header")
    private FoodNtrIrdntInfoResponseHeader header;
    @JsonProperty("body")
    private FoodNtrIrdntInfoResponseBody body;
}
