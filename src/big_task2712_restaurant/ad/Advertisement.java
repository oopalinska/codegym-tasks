package big_task2712_restaurant.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long amountPaid;
    private int impressionsRemaining;
    private int duration;
    private long amountPerImpression;

    public void revalidate() {
        if (impressionsRemaining <= 0) {
            throw new UnsupportedOperationException();
        }
        impressionsRemaining--;
    }

    public Advertisement(final Object content,
                         final String name,
                         final long amountPaid,
                         final int impressionsRemaining,
                         final int duration) {
        this.content = content;
        this.name = name;
        this.amountPaid = amountPaid;
        this.impressionsRemaining = impressionsRemaining;
        this.duration = duration;
        this.amountPerImpression = amountPaid / impressionsRemaining;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerImpression() {
        return amountPerImpression;
    }
}
