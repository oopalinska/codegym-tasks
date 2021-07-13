package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Cook;
import big_task2712_restaurant.kitchen.Waiter;
import big_task2712_restaurant.statistics.StatisticsManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATION_INTERVAL = 100;

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i));
        }
        Cook cook1 = new Cook("Nusret");
        Cook cook2 = new Cook("Jay Fai");
        StatisticsManager.getInstance().register(cook1);
        StatisticsManager.getInstance().register(cook2);
        OrderManager orderManager = new OrderManager();
        for(Tablet tablet : tablets) {
            tablet.addObserver(orderManager);
            tablet.addObserver(orderManager);
        }
        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);
        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATION_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();
        try {
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
}