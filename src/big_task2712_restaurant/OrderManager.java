package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Cook;
import big_task2712_restaurant.kitchen.Order;
import big_task2712_restaurant.statistics.StatisticsManager;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread thread = new Thread(() -> {
            Set<Cook> cooks = StatisticsManager.getInstance().getCooks();
            while(true) {
                if (!orderQueue.isEmpty()) {
                    for (Cook cook : cooks) {
                        if (!cook.isBusy()) {
                            cook.startCookingOrder(Objects.requireNonNull(orderQueue.poll()));
                        }
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void update(final Observable o, final Object arg) {
        orderQueue.add((Order) arg);
    }
}

