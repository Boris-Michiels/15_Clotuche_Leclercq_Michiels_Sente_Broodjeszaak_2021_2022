package model.kortingStrategies;

public enum KortingStrategyEnum {
    NoDiscount("No Discount"),
    tenProcent("10 procent op hele bestelling"),
    cheapestbroodje("Cheapest broodje op bestelling for free");


    private final String korting;


    KortingStrategyEnum(String korting) {
        this.korting = korting;
    }

    public String getTekst() {
        return korting;
    }
}
