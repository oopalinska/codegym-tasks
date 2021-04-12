package task2504_thread_states;

/*
A switch for threads

*/

public class Solution {
    public static void processThreads(Thread... threads) {
        // Implement this method
        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    if (thread.isInterrupted()) {
                        System.out.println(thread.getPriority());
                    }
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
