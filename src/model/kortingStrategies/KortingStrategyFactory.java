package model.kortingStrategies;

public class KortingStrategyFactory {
    public static KortingStrategy createKortingStrategy(String kortingString) {
        KortingStrategyEnum kortingStrategyEnum = KortingStrategyEnum.valueOf(kortingString);
        String classPath = kortingStrategyEnum.getClassPath();
        KortingStrategy kortingStrategy = null;
        try{
            kortingStrategy = (KortingStrategy) Class.forName(classPath).newInstance();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return kortingStrategy;
    }


}
