package big_task2810_aggregator.vo;

import java.util.Objects;

public class JobPosting {
    private String title;
    private String city;
    private String companyName;
    private String websiteName;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(final String websiteName) {
        this.websiteName = websiteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof JobPosting)) return false;
        final JobPosting that = (JobPosting) o;
        return Objects.equals(title, that.title) && Objects.equals(city, that.city) && Objects.equals(companyName, that.companyName) && Objects.equals(websiteName, that.websiteName) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, city, companyName, websiteName, url);
    }
}