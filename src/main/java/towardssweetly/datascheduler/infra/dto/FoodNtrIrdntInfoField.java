package towardssweetly.datascheduler.infra.dto;

public enum FoodNtrIrdntInfoField {
    NAME("DESC_KOR"),
    SERVING_SIZE_GRAM("SERVING_WT"),
    CALORIES_KCAL("NUTR_CONT1"),
    CARBOHYDRATES_GRAM("NUTR_CONT2"),
    PROTEIN_GRAM("NUTR_CONT3"),
    FAT_GRAM("NUTR_CONT4"),
    SUGARS_GRAM("NUTR_CONT5"),
    SODIUM_MILLI_GRAM("NUTR_CONT6"),
    CHOLESTRAOL_MILLI_GRAM("NUTR_CONT7"),
    SATURATED_FATTY_ACIDS_GRAM("NUTR_CONT8"),
    TRANS_FATTY_ACIDS_GRAM("NUTR_CONT9"),
    BEGIN_YEAR("BGN_YEAR"),
    MANUFACTURER("ANIMAL_PLANT");

    private final String value;

    FoodNtrIrdntInfoField(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
