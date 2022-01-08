package model.kortingStrategies;

public class KortingStrategyFactory {
    public static KortingStrategy KortingStrategyFactory(String kortingString){
        KortingStrategy kortingStrategy = null;

        KortingStrategyEnum kortingStrategyEnum = KortingStrategyEnum.valueOf(kortingString);
        try{
            kortingStrategy = (KortingStrategy) Class.forName(String.valueOf(kortingStrategyEnum.getTekst())).getConstructor().newInstance();
        }catch (Exception e){

        }
        return kortingStrategy;
    }


}
