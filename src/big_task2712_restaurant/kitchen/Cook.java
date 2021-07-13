package big_task2712_restaurant.kitchen;

import big_task2712_restaurant.ConsoleHelper;
import big_task2712_restaurant.statistics.StatisticsManager;
import big_task2712_restaurant.statistics.event.OrderReadyEventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private final String name;
    private boolean busy;

    public Cook(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        setBusy(true);
        int totalCookingTime = order.getTotalCookingTime();
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()
                + ", cooking time " + totalCookingTime + " min");
        setChanged();
        notifyObservers(order);
        try {
            Thread.sleep(totalCookingTime * 10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StatisticsManager.getInstance().record(
                new OrderReadyEventDataRow(
                        order.getTablet().toString(),
                        this.name,
                        totalCookingTime * 60,
                        order.getDishes()));
        setBusy(false);
    }

    public boolean isBusy() {
        return busy;
    }

    private void setBusy(boolean busy) {
        this.busy = busy;
    }
}
