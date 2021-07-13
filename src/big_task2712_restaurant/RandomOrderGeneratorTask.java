package big_task2712_restaurant;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private final List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while(true) {
                int random = (int) (Math.random() * tablets.size());
                Tablet tablet = tablets.get(random);
                tablet.createOrder();
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}