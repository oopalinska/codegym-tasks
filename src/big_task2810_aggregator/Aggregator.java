package big_task2810_aggregator;

import big_task2810_aggregator.model.LinkedinStrategy;
import big_task2810_aggregator.model.Model;
import big_task2810_aggregator.model.Provider;
import big_task2810_aggregator.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Provider provider = new Provider(new LinkedinStrategy());
        Model model = new Model(view, provider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.emulateCitySelection();
    }
}
