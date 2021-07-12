package big_task2712_restaurant;

import big_task2712_restaurant.ad.AdvertisementManager;
import big_task2712_restaurant.ad.NoVideoAvailableException;
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
        Order order = null;
        try {
            order = new Order(this);
            if(order.isEmpty()) {
                return order;
            }
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            manager.processVideos();
            setChanged();
            notifyObservers(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
            return null;
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the following order: " + order);
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



