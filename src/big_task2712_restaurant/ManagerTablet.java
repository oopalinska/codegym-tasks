package big_task2712_restaurant;

import big_task2712_restaurant.statistics.StatisticsManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class ManagerTablet {
    private StatisticsManager statisticsManager = StatisticsManager.getInstance();


    public void printAdRevenue() {
        Map<String, Long> revenuesMap = statisticsManager.getRevenuesMap();
        for (String key : revenuesMap.keySet()) {
            double amount = 1.0 * revenuesMap.get(key) / 100;
            String formattedAmount = String.format("%.2f", amount);
            ConsoleHelper.writeMessage(key + " - " + formattedAmount);
        }
    }
    public void printCookUtilization() {
        Map<String, Map<String, Integer>> workTimeMap = statisticsManager.getCookWorkTimeMap();
        for (String key : workTimeMap.keySet()) {
            ConsoleHelper.writeMessage(key);
            Map<String, Integer> cooksInfo = workTimeMap.get(key);
            ArrayList<String> cookNames = new ArrayList<>(cooksInfo.keySet());
            Collections.sort(cookNames);
            for (String cooksName : cookNames) {
                Integer cookingTime = (cooksInfo.get(cooksName)+59)/60;
                if (!cookingTime.equals(0)) {
                    ConsoleHelper.writeMessage(cooksName + " - " + cookingTime + " min");
                }
            }
        }
    }
    public void printActiveVideoSet() {

    }
    public void printArchivedVideoSet() {

    }
}
