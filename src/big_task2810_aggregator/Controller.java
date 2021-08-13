package big_task2810_aggregator;

import big_task2810_aggregator.model.Provider;
import big_task2810_aggregator.vo.JobPosting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<JobPosting> vacancies = new ArrayList<>();
        for (Provider provider : providers) {
            vacancies.addAll(provider.getJavaJobPostings("MyTown"));
        }
        System.out.println(vacancies.size());
    }
}
