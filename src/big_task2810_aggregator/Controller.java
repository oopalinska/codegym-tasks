package big_task2810_aggregator;

import big_task2810_aggregator.model.Model;

public class Controller {
    private Model model;

    public Controller(final Model model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }
    public void onCitySelected(String cityName) {
        model.selectCity(cityName);
    }
}