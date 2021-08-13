package big_task2810_aggregator.model;

import big_task2810_aggregator.vo.JobPosting;

import java.util.List;

public interface Strategy {

    List<JobPosting> getJobPostings(String searchString);
}
