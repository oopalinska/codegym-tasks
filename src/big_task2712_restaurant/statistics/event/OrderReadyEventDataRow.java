package big_task2712_restaurant.statistics.event;


import big_task2712_restaurant.kitchen.Dish;

import java.util.Date;
import java.util.List;

public class OrderReadyEventDataRow implements EventDataRow {
    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> dishesInOrder;
    private Date currentDate;

    public OrderReadyEventDataRow(String tabletName,
                                  String cookName,
                                  int cookingTimeSeconds,
                                  List<Dish> dishesInOrder) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.dishesInOrder = dishesInOrder;
        this.currentDate = new Date();

    }

    @Override
    public EventType getType() {
        return EventType.ORDER_READY;
    }
}