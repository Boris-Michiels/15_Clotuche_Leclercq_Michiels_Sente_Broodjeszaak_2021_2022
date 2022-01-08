package model.kortingStrategies;

public class NoDiscount implements KortingStrategy {
    @Override
    public double prijsBerekingNaKorting(double price) {
        return price;
    }
}
