package big_task2712_restaurant.statistics;

import big_task2712_restaurant.kitchen.Cook;
import big_task2712_restaurant.statistics.event.EventDataRow;
import big_task2712_restaurant.statistics.event.EventType;
import big_task2712_restaurant.statistics.event.OrderReadyEventDataRow;
import big_task2712_restaurant.statistics.event.VideosSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticsManager {
    private static StatisticsManager statisticsManager = new StatisticsManager();
    private StatisticsStorage statisticsStorage = new StatisticsStorage();
    private Set<Cook> cooks = new HashSet<>();
    private StatisticsManager() {
    }
    public static StatisticsManager getInstance() {
        return statisticsManager;
    }

    public Map<String, Long> getRevenuesMap() {
        Map<String, Long> result = new HashMap();
        List<EventDataRow> rows = statisticsStorage.get(EventType.VIDEOS_SELECTED);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        long totalDayProfit = 0L;
        for (EventDataRow row : rows) {
            VideosSelectedEventDataRow dataRow = (VideosSelectedEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!result.containsKey(date)) {
                result.put(date, 0L);
            }
            totalDayProfit += dataRow.getAmount();
            result.put(date, result.get(date) + dataRow.getAmount());
        }

        result.put("Total", totalDayProfit);

        return result;
    }
    public Map<String, Map<String, Integer>> getCookWorkTimeMap() {
        Map<String, Map<String, Integer>> result = new HashMap(); //name, time
        List<EventDataRow> rows = statisticsStorage.get(EventType.ORDER_READY);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow row : rows) {
            OrderReadyEventDataRow dataRow = (OrderReadyEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!result.containsKey(date)) {
                result.put(date, new HashMap<>());
            }
            Map<String, Integer> cookMap = result.get(date);
            String cookName = dataRow.getCookName();
            if (!cookMap.containsKey(cookName)) {
                cookMap.put(cookName, 0);
            }
            Integer totalWorkingTime = cookMap.get(cookName);
            cookMap.put(cookName, totalWorkingTime + dataRow.getTime());
        }

        return result;
    }

    public void record(EventDataRow data) {
        statisticsStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Set<Cook> getCooks() {
        return cooks;
    }

    private class StatisticsStorage {

        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        public StatisticsStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<>());
            }
        }
        private List<EventDataRow> get(EventType type) {
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            return this.storage.get(type);
        }
        private void put(EventDataRow data) {
            EventType type = data.getType();
            if (!this.storage.containsKey(type)) {
                throw new UnsupportedOperationException();
            }
            this.storage.get(type).add(data);
        }
    }
}
