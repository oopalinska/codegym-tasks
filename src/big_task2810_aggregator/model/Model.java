package big_task2810_aggregator.model;

import big_task2810_aggregator.view.View;
import big_task2810_aggregator.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(final View view, final Provider... providers) {
        if (view == null || providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }
    public void selectCity(String city) {
        List<JobPosting> postings = new ArrayList<>();
        for (Provider provider : providers) {
            postings.addAll(provider.getJavaJobPostings(city));
        }
        view.update(postings);
    }
}
