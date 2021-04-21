package task2511_local_uncaught_exception;

import java.util.TimerTask;

/*
Arming ourselves to the teeth!

*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = (t, e) -> {
            StringBuilder asterisks = new StringBuilder();
            for (int i = 0; i < t.getName().length(); i++) {
                asterisks.append("*");
            }
            System.out.println(e.getMessage().replace(t.getName(), asterisks));
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}

