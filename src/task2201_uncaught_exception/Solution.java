package task2201_uncaught_exception;

/*
Threads of a string or stringy threads? That's the question

*/

public class Solution {
    public static void main(String[] args) {
        //when we create new Solution object, constructor is called (line 21)
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");
        // This line is crucial! If we don't include it, OurUncaughtExceptionHandler can never be called.
        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());
        // Start the run() method for Task class for every thread
        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {

        try {
            return string.substring(string.indexOf('\t') + 1, string.lastIndexOf('\t'));
        } catch (Throwable e) {
            if (threadName.equals(FIRST_THREAD_NAME)) throw new StringForFirstThreadTooShortException();
            if (threadName.equals(SECOND_THREAD_NAME)) throw new StringForSecondThreadTooShortException();
            else throw new RuntimeException();
        }
    }
}

