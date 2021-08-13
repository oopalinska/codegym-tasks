package big_task2810_aggregator;

import big_task2810_aggregator.model.Provider;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(null);
        Controller controller = new Controller(provider);
        System.out.println(controller);
    }
}
