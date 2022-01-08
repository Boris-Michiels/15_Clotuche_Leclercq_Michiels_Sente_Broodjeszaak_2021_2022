package model.kortingStrategies;

public class TenPercentDiscount implements KortingStrategy {
    @Override
    public double prijsBerekingNaKorting(double price) {
        double discount = price/10;
        return price-discount;
    }
}
