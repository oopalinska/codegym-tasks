package big_task2712_restaurant.statistics.event;

import java.util.Date;

public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}

