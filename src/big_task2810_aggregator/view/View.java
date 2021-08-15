package big_task2810_aggregator.view;

import big_task2810_aggregator.Controller;
import big_task2810_aggregator.vo.JobPosting;

import java.util.List;

public interface View {
    void update(List<JobPosting> jobPostings);
    void setController(Controller controller);
}
