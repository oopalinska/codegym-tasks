package big_task2712_restaurant.kitchen;


import big_task2712_restaurant.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {
    public TestOrder(final Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        this.dishes = new ArrayList<>();

        Dish[] values = Dish.values();
        int numberOfDishesToOrder = (int) (Math.random() * 3 + 2);
        for (int i = 0; i < numberOfDishesToOrder; i++) {
            int dishIndex = (int) (Math.random() * values.length);
            dishes.add(values[dishIndex]);
        }
    }
}
