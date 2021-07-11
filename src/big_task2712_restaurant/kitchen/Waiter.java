package big_task2712_restaurant.kitchen;

import big_task2712_restaurant.ConsoleHelper;
import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {

    @Override
    public void update(final Observable cook, final Object order) {
        ConsoleHelper.writeMessage(order.toString() + " was prepared by " + cook.toString());
    }
}
