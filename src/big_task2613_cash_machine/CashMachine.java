package big_task2613_cash_machine;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.requestCurrencyCode();
        String[] input = ConsoleHelper.getTwoValidNumbers(currencyCode);
        int denomination = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulator.addAmount(denomination, count);
    }
}
