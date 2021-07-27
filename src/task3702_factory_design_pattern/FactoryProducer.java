package task3702_factory_design_pattern;


import task3702_factory_design_pattern.female.FemaleFactory;
import task3702_factory_design_pattern.male.MaleFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(HumanFactoryType type) {
        if (type == HumanFactoryType.MALE) {
            return new MaleFactory();
        } else {
            return new FemaleFactory();
        }
    }

    public enum HumanFactoryType {
        MALE, FEMALE
    }
}
