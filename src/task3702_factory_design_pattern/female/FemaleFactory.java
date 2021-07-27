package task3702_factory_design_pattern.female;


import task3702_factory_design_pattern.AbstractFactory;
import task3702_factory_design_pattern.Human;

public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        if (age <= KidGirl.MAX_AGE) {
            return new KidGirl();
        }
        else if (age <= TeenGirl.MAX_AGE) {
            return new TeenGirl();
        }
        else {
            return new Woman();
        }
    }
}
