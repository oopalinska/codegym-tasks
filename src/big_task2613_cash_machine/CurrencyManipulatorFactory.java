package big_task2613_cash_machine;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static final Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String currencyUpper = currencyCode.toUpperCase();
        if (!map.containsKey(currencyUpper)) {
            map.put(currencyUpper, new CurrencyManipulator(currencyUpper));
        }
        return map.get(currencyUpper);
    }
}