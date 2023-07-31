package towardssweetly.datascheduler.infra.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import towardssweetly.datascheduler.config.CustomItemDeserializer;

import java.time.LocalDate;

@JsonDeserialize(using = CustomItemDeserializer.class)
public record FoodNtrIrdntInfoResponseItem(
        String name,
        Double servingSizeGram,
        Double caloriesKcal,
        Double carbohydratesGram,
        Double proteinGram,
        Double fatGram,
        Double sugarsGram,
        Double sodiumMilligram,
        Double cholesterolMilligram,
        Double saturatedFattyAcidsGram,
        Double transFattyAcidsGram,
        LocalDate beginYear,
        String manufacturer
) {
}
