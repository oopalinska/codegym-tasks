package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Cook;
import big_task2712_restaurant.kitchen.Order;
import big_task2712_restaurant.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATION_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i));
        }
        Cook cook1 = new Cook("Nusret");
        Cook cook2 = new Cook("Jay Fai");
        cook1.setQueue(orderQueue);
        cook2.setQueue(orderQueue);
        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);
        Thread threadCook1 = new Thread(cook1);
        Thread threadCook2 = new Thread(cook2);
        threadCook1.start();
        threadCook2.start();
        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATION_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        ManagerTablet managerTablet = new ManagerTablet();
        managerTablet.printAdRevenue();
        managerTablet.printCookUtilization();
        managerTablet.printActiveVideoSet();
        managerTablet.printArchivedVideoSet();
    }

    public static LinkedBlockingQueue<Order> getOrderQueue() {
        return orderQueue;
    }
}