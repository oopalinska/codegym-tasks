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
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));   //weight=277
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));   //weight=11
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));     //weight=333
    }


    public static AdvertisementStorage getInstance() {
        return instance;
    }
}
