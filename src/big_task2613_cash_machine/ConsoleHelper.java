package big_task2613_cash_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return bis.readLine();
        } catch (IOException ignored) {

        }
        return "";
    }

    public static String requestCurrencyCode() {
        writeMessage("Please enter a currency code:");
        String code = readString();
        while (!(code.length() == 3)) {
            writeMessage("The code is invalid. Please try again.");
            code = readString();
        }
        return code.toUpperCase();

    }

    public static String[] getTwoValidNumbers(String currencyCode) {
        writeMessage(String.format("Please enter denomination and number of banknotes. \n" +
                "They have to be two positive numbers separated by space, e.g. '10 2' means 20 %s.", currencyCode));
        String input = readString();
        while (!isValid(input)) {
            writeMessage("Your input is not correct! Please try again.");
            input = readString();
        }
        return input.trim().split("\\s+");
    }

    private static boolean isValid(String input) {
        try {
            String trim = input.trim();
            String[] split = trim.split("\\s+");
            if (split.length != 2) {
                return false;
            }
            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[1]);
            return first > 0 && second > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

