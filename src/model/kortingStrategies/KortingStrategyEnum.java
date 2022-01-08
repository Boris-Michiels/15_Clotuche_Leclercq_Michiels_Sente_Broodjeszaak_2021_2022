package model.kortingStrategies;

public enum KortingStrategyEnum {
    NO_DISCOUNT("model.kortingStrategies.NoDiscount"),
    TEN_PERCENT("model.kortingStrategies.TenPercentDiscount"),
    FREE_SANDWICH("model.kortingStrategies.FreeSandwichDiscount");

    private final String classPath;

    KortingStrategyEnum(String korting) {
        this.classPath = korting;
    }

    public String getClassPath() {
        return classPath;
    }
}
