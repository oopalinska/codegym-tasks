package task3702_factory_design_pattern.male;

import task3702_factory_design_pattern.AbstractFactory;
import task3702_factory_design_pattern.Human;
import task3702_factory_design_pattern.TeenBoy;

public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        if (age <= KidBoy.MAX_AGE) {
            return new KidBoy();
        }
        else if (age <= TeenBoy.MAX_AGE) {
            return new TeenBoy();
        }
        else {
            return new Man();
        }
    }
}
