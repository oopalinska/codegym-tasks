package big_task2712_restaurant.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long amountPaid;
    private int impressionsRemaining;
    private int duration;

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
    }
}
