package big_task2712_restaurant.ad;

import big_task2712_restaurant.ConsoleHelper;

import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> adverts = storage.list();
        if (adverts.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        StringBuilder sb = new StringBuilder();
        for (Advertisement advert : adverts) {
            sb.append("Displaying ").append(advert.getName());
            long advertCost = advert.getAmountPerImpression();
            sb.append("... ").append(advertCost);
            sb.append(", ").append(advertCost / advert.getDuration() * 1000);
            System.out.println(sb.toString());
            ConsoleHelper.writeMessage(sb.toString());
            advert.revalidate();
        }
    }
}

