package big_task2712_restaurant;

import big_task2712_restaurant.ad.AdvertisementManager;
import big_task2712_restaurant.ad.NoVideoAvailableException;
import big_task2712_restaurant.kitchen.Order;
import big_task2712_restaurant.kitchen.TestOrder;

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
        Order order = null;
        try {
            order = new Order(this);
            final Order order1 = prepareOrder(order);
            if (order1 != null) return order1;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
            return null;
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the following order: " + order);
        }
        return order;
    }

    public void createTestOrder() {
        Order testOrder = null;
        try {
            testOrder = new TestOrder(this);
            prepareOrder(testOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the following order: " + testOrder);
        }
    }

    private Order prepareOrder(final Order order) {
        if(order.isEmpty()) {
            return order;
        }
        AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
        manager.processVideos();
        setChanged();
        notifyObservers(order);
        return null;
    }
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}




