package big_task2810_aggregator.view;

import big_task2810_aggregator.Controller;
import big_task2810_aggregator.vo.JobPosting;

import java.util.List;

public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(final List<JobPosting> jobPostings) {

    }

    @Override
    public void setController(final Controller controller) {
        this.controller = controller;
    }
}
