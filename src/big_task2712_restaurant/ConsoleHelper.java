package big_task2712_restaurant;

import big_task2712_restaurant.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException {
                return reader.readLine();
        }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> listToOrder = new ArrayList<>();
        writeMessage("Please select the dish or write EXIT: ");
        writeMessage(Dish.allDishesToString());
        while (true) {
            String readString = readString().trim();
            if (readString.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                listToOrder.add(Dish.valueOf(readString.toUpperCase()));
                writeMessage(readString + " has been added to your order.");
            } catch (IllegalArgumentException e) {
                writeMessage("There is no such dish... Try again.");
            }
        }
        return listToOrder;
    }
}
