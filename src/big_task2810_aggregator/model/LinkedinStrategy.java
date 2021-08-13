package big_task2810_aggregator.model;

import big_task2810_aggregator.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy {

    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> allVacancies = new ArrayList<>();

        int start = 0;
        try {
            do {
                Document doc = getDocument(searchString, start);

                Elements vacanciesHtmlList = doc.getElementsByClass("jobs-search-result-item");

                if (vacanciesHtmlList.isEmpty()) break;

                for (Element element : vacanciesHtmlList) {
                    Elements title = element.getElementsByClass("listed-job-posting__title");
                    Elements url = element.getElementsByAttributeValue("itemprop", "url");
                    Elements locations = element.getElementsByClass("listed-job-posting__location");
                    Elements companyName = element.getElementsByClass("listed-job-posting__company");

                    JobPosting vacancy = new JobPosting();
                    vacancy.setWebsiteName("linkedin.com");
                    vacancy.setTitle(title.get(0).text());
                    vacancy.setUrl(url.attr("content"));
                    vacancy.setCity(locations.get(0).text());
                    vacancy.setCompanyName(companyName.get(0).text());

                    allVacancies.add(vacancy);
                }

                start += 25;
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allVacancies;
    }

    protected Document getDocument(String searchString, int start) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, start))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")
                .get();
    }
}
