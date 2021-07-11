package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        Cook cook = new Cook("Nusret");
        tablet.addObserver(cook);
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}
