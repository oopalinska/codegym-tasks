package task2201_uncaught_exception;

public class Task implements Runnable {
    private String initialString;
    private Solution solution;

    public Task(Solution solution, String initialString) {
        this.solution = solution;
        this.initialString = initialString;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String str = this.initialString;
        do {
            System.out.println(name + str);
            // Everytime we go through the loop, we change the str to a substring of previous str version
            // and finally when the str is too short, we get an exception and OurUncaughtExceptionHandler is called
            // (check how it happens in Solution's getPartOfString() method implementation)
        } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
    }
}