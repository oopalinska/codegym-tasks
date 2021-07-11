package big_task2712_restaurant.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

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
}
