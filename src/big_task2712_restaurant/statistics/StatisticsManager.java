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
        statisticsStorage.put(data);
    }

    private class StatisticsStorage {

        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        public StatisticsStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<>());
            }
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
