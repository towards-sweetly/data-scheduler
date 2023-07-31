package towardssweetly.datascheduler.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class FoodNtrIrdntInfoResponseBody {
    @JsonProperty("pageNo")
    private int pageNumber;
    @JsonProperty("totalCount")
    private int totalCount;
    @JsonProperty("numOfRows")
    private int count;
    @JsonProperty("items")
    private List<FoodNtrIrdntInfoResponseItem> items;
}
