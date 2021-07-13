package big_task2712_restaurant.kitchen;

import big_task2712_restaurant.ConsoleHelper;
import big_task2712_restaurant.statistics.StatisticsManager;
import big_task2712_restaurant.statistics.event.OrderReadyEventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private final String name;

    public Cook(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()
                + ", cooking time " + order.getTotalCookingTime() + " min");
        setChanged();
        notifyObservers(order);
        StatisticsManager.getInstance().record(
                new OrderReadyEventDataRow(
                        order.getTablet().toString(),
                        this.name,
                        order.getTotalCookingTime() * 60,
                        order.getDishes()));
    }
}