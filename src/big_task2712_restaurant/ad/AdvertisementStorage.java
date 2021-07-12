package big_task2712_restaurant.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    public List<Advertisement> list() {
        return videos;
    }
    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        new Advertisement(someContent, "First Video", 5000, 100, 3 * 60); // 3 min
        new Advertisement(someContent, "Second Video", 100, 10, 15 * 60); // 15 min
        new Advertisement(someContent, "Third Video", 400, 2, 10 * 60); // 10 min
    }

    public static AdvertisementStorage getInstance() {
        return instance;
    }
}
