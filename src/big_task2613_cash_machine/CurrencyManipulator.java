package big_task2613_cash_machine;

import big_task2613_cash_machine.exception.InsufficientFundsException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(final String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            totalAmount += entry.getKey() * entry.getValue();
        }
        return totalAmount;
    }

    public boolean hasMoney() {
        return !this.denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws InsufficientFundsException {
        int amountLeft = expectedAmount;
        Map<Integer, Integer> denominationsCopy = new HashMap<>(denominations);
        ArrayList<Integer> keys = getSortedAndReversedKeysArray();

        TreeMap<Integer, Integer> resultMap = new TreeMap<>(Comparator.reverseOrder());

        for (Integer denomination : keys) {
            Integer howManyCurrents = denominationsCopy.get(denomination);
            while (true) {
                if (amountLeft < denomination || howManyCurrents == 0) {
                    denominationsCopy.put(denomination, howManyCurrents);
                    break;
                }
                amountLeft -= denomination;
                howManyCurrents--;

                if (resultMap.containsKey(denomination)) {
                    resultMap.put(denomination, resultMap.get(denomination) + 1);
                } else {
                    resultMap.put(denomination, 1);
                }
            }
        }
        refreshDenominationsIfOperationSuccess(amountLeft, denominationsCopy);

        return resultMap;
    }

    private void refreshDenominationsIfOperationSuccess(int amountLeft, Map<Integer,Integer> denominationsCopy) throws InsufficientFundsException {
        if (amountLeft > 0) {
            throw new InsufficientFundsException();
        } else {
            denominations.clear();
            denominations.putAll(denominationsCopy);
        }
    }

    private ArrayList<Integer> getSortedAndReversedKeysArray() {
        ArrayList<Integer> keys = new ArrayList<>(denominations.keySet());
        Collections.sort(keys);
        Collections.reverse(keys);
        return keys;
    }
}

