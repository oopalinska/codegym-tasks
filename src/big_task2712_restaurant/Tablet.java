package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(final int number) {
        this.number = number;
    }
    public void createOrder() {
        try {
            Order order = new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}


