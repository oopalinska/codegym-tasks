package big_task2712_restaurant.statistics.event;

import big_task2712_restaurant.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideosSelectedEventDataRow implements EventDataRow {
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public VideosSelectedEventDataRow(List<Advertisement> optimalVideoSet,
                                      long amount,
                                      int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }
}
