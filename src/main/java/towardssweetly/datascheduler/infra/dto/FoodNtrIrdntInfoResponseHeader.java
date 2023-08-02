package towardssweetly.datascheduler.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FoodNtrIrdntInfoResponseHeader {
    @JsonProperty("resultCode")
    private int code;
    @JsonProperty("resultMsg")
    private String message;
}
