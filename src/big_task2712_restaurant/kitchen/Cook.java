package big_task2712_restaurant.kitchen;

import big_task2712_restaurant.ConsoleHelper;
import big_task2712_restaurant.Tablet;
import big_task2712_restaurant.statistics.StatisticsManager;
import big_task2712_restaurant.statistics.event.OrderReadyEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private final String name;

    public Cook(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(final Observable tablet, final Object order) {
        Order finalOrder = (Order) order;
        Tablet finalTablet = (Tablet) tablet;
        ConsoleHelper.writeMessage("Start cooking - " + finalOrder.toString() + ", cooking time " + finalOrder.getTotalCookingTime() + " min");
        setChanged();
        notifyObservers(order);
        StatisticsManager.getInstance().record(
                new OrderReadyEventDataRow(
                        finalTablet.toString(),
                        this.name,
                        finalOrder.getTotalCookingTime() * 60,
                        finalOrder.getDishes()));
    }
}
