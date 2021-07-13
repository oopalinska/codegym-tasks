package big_task2712_restaurant.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticsAdvertisementManager {
    private static final StatisticsAdvertisementManager statisticsAdvertisementManager = new StatisticsAdvertisementManager();
    private final AdvertisementStorage advertisementStorage;
    private StatisticsAdvertisementManager() {
       advertisementStorage = AdvertisementStorage.getInstance();
    }
    public static StatisticsAdvertisementManager getInstance() {
        return statisticsAdvertisementManager;
    }
    public List<Advertisement> getListOfCommercials(boolean isActive) {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advert : advertisementStorage.list()) {
            if ((!isActive && !advert.isActive())  || (isActive && advert.isActive())) {
                result.add(advert);
            }
        }
        return result;
    }

}
