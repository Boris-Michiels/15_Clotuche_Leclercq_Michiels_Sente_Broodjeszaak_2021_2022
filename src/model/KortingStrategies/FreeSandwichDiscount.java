package model.KortingStrategies;

public class FreeSandwichDiscount implements KortingStrategy {
    @Override
    public double prijsBerekingNaKorting(double price) {
        return 0;
    }
}
