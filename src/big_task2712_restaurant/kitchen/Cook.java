package big_task2712_restaurant.kitchen;

import big_task2712_restaurant.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {
    private final String name;

    public Cook(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(final Observable tablet, final Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order.toString());
    }
}
