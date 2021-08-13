package big_task2810_aggregator.model;

import big_task2810_aggregator.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(final String searchString) {
        return new ArrayList<>();
    }
}

