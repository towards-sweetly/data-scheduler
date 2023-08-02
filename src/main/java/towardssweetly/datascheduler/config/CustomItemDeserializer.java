package towardssweetly.datascheduler.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import towardssweetly.datascheduler.infra.dto.FoodNtrIrdntInfoField;
import towardssweetly.datascheduler.infra.dto.FoodNtrIrdntInfoResponseItem;

import java.io.IOException;
import java.time.LocalDate;

import static towardssweetly.datascheduler.infra.dto.FoodNtrIrdntInfoField.*;

/**
 * {@link FoodNtrIrdntInfoResponseItem} 역직렬화를 위한 클래스.
 * Double 필드에 N/A 문자열이 입력되는 문제를 해결한다.
 */
public class CustomItemDeserializer extends JsonDeserializer<FoodNtrIrdntInfoResponseItem> {
    @Override
    public FoodNtrIrdntInfoResponseItem deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        var node = (JsonNode) p.getCodec().readTree(p);
        return new FoodNtrIrdntInfoResponseItem(
                getField(node, NAME).asText(),
                parseDouble(getField(node, SERVING_SIZE_GRAM)),
                parseDouble(getField(node, CALORIES_KCAL)),
                parseDouble(getField(node, CARBOHYDRATES_GRAM)),
                parseDouble(getField(node, PROTEIN_GRAM)),
                parseDouble(getField(node, FAT_GRAM)),
                parseDouble(getField(node, SUGARS_GRAM)),
                parseDouble(getField(node, SODIUM_MILLI_GRAM)),
                parseDouble(getField(node, CHOLESTRAOL_MILLI_GRAM)),
                parseDouble(getField(node, SATURATED_FATTY_ACIDS_GRAM)),
                parseDouble(getField(node, TRANS_FATTY_ACIDS_GRAM)),
                parseYear(getField(node, BEGIN_YEAR)),
                getField(node, MANUFACTURER).asText()
        );
    }

    private static JsonNode getField(JsonNode node, FoodNtrIrdntInfoField field) {
        return node.get(field.getValue());
    }

    private Double parseDouble(JsonNode node) {
        if ("N/A".equals(node.asText())) {
            return null;
        }
        return node.asDouble();
    }

    private LocalDate parseYear(JsonNode bgnYear) {
        return LocalDate.of(Integer.parseInt(bgnYear.asText()), 1, 1);
    }
}
