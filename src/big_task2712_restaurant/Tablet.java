package big_task2712_restaurant;

import big_task2712_restaurant.ad.AdvertisementManager;
import big_task2712_restaurant.ad.NoVideoAvailableException;
import big_task2712_restaurant.kitchen.Order;
import big_task2712_restaurant.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(final int number) {
        this.number = number;
        setQueue(Restaurant.getOrderQueue());
    }
    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            prepareOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the following order: " + order);
        }
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
        try {
            queue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return order;
    }
    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void setQueue(final LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
}




