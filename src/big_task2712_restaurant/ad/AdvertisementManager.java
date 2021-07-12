package big_task2712_restaurant.ad;

import big_task2712_restaurant.statistics.StatisticsManager;
import big_task2712_restaurant.statistics.event.VideosSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> optimalVideoSet;
    private long maxAmount;
    private int totalTimeSecondsLeft;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> adverts = storage.list();
        if (adverts.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        this.totalTimeSecondsLeft = Integer.MAX_VALUE;
        obtainOptimalVideoSet(new ArrayList<>(), timeSeconds, 0L);
        StatisticsManager.getInstance().record(new VideosSelectedEventDataRow(
                optimalVideoSet,
                maxAmount,
                totalTimeSecondsLeft));
        displayAdvertisement();
    }
    private void obtainOptimalVideoSet(List<Advertisement> videos, int currentTimeSecondsLeft, long currentAmount) {
        if (currentTimeSecondsLeft < 0) {
            return;
        } else
        if (currentAmount > maxAmount
                || currentAmount == maxAmount && (totalTimeSecondsLeft > currentTimeSecondsLeft
                || totalTimeSecondsLeft == currentTimeSecondsLeft && videos.size() < optimalVideoSet.size()))
        {
            this.totalTimeSecondsLeft = currentTimeSecondsLeft;
            this.optimalVideoSet = videos;
            this.maxAmount = currentAmount;
            if (currentTimeSecondsLeft == 0) {
                return;
            }
        }

        ArrayList<Advertisement> tmp = getActualAdvertisements();
        tmp.removeAll(videos);
        for (Advertisement ad : tmp) {
            if (!ad.isActive()) continue;
            ArrayList<Advertisement> currentList = new ArrayList<>(videos);
            currentList.add(ad);
            obtainOptimalVideoSet(currentList, currentTimeSecondsLeft - ad.getDuration(), currentAmount + ad.getAmountPerImpression());
        }
    }
    private ArrayList<Advertisement> getActualAdvertisements() {
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.isActive()) {
                advertisements.add(ad);
            }
        }
        return advertisements;
    }
    private void displayAdvertisement() {
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Collections.sort(optimalVideoSet, (o1, o2) -> {
            long l = o2.getAmountPerImpression() - o1.getAmountPerImpression();
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
        });

        for (Advertisement ad : optimalVideoSet) {
            displayInPlayer(ad);
            ad.revalidate();
        }
    }

    private void displayInPlayer(Advertisement advertisement) {
        System.out.println("Displaying " + advertisement.getName() + "... " + advertisement.getAmountPerImpression() +
                ", " + (1000 * advertisement.getAmountPerImpression() / advertisement.getDuration()));
    }
}
