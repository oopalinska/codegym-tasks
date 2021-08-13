package big_task2810_aggregator.model;

import big_task2810_aggregator.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(final String searchString) {
        try {
            Document document = Jsoup.connect(String.format(URL_FORMAT, "MyTown", 0)).userAgent("Mozilla/5.0 (jsoup)").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

