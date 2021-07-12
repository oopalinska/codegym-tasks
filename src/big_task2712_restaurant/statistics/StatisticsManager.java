package big_task2712_restaurant.statistics;

import big_task2712_restaurant.statistics.event.EventDataRow;
import big_task2712_restaurant.statistics.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsManager {
    private static StatisticsManager statisticsManager = new StatisticsManager();
    private StatisticsStorage statisticsStorage = new StatisticsStorage();

    private StatisticsManager() {
    }

    public static StatisticsManager getInstance() {
        return statisticsManager;
    }
    public void record(EventDataRow data) {

    }

    private class StatisticsStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticsStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }
    }
}

