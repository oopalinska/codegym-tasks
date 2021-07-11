package big_task2712_restaurant.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder();
        for (Dish dish : Dish.values()) {
            if (result.toString().equals("")) {
                result.append(dish.name());
            }
            else {
                result.append(", ").append(dish.name());
            }
        }
        return result.toString();
    }

    public int getDuration() {
        return duration;
    }

    Dish(final int duration) {
        this.duration = duration;
    }
}