package big_task2712_restaurant.kitchen;

import big_task2712_restaurant.ConsoleHelper;
import big_task2712_restaurant.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(final Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        StringBuilder orderText = new StringBuilder("");
        if (dishes.isEmpty()) {
            return orderText.toString();
        }
        orderText.append("Your order: [").append(dishes.get(0).name());
        for (int i = 1; i < dishes.size(); i++) {
            orderText.append(", ").append(dishes.get(i).name());
        }
        orderText.append("] from ").append(tablet);
        return orderText.toString();
    }
    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }
    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}

