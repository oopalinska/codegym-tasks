package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(final int number) {
        this.number = number;
    }
    public Order createOrder() {
        Order order;
        try {
            order = new Order(this);
            setChanged();
            notifyObservers(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
            return null;
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}



