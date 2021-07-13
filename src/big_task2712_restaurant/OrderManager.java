package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    @Override
    public void update(final Observable o, final Object arg) {
        orderQueue.add((Order) arg);
    }
}
