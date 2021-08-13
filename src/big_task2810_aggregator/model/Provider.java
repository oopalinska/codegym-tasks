package big_task2810_aggregator.model;

import big_task2810_aggregator.vo.JobPosting;

import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(final Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }

    public List<JobPosting> getJavaJobPostings(String searchString) {
        return strategy.getJobPostings(searchString);
    }
}

