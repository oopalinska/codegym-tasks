package task2505_uncaught_exception;

/*
No idiots

*/

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);  - this was causing the exception not to be logged
        }

        @Override
        public void run() {
            throw new NullPointerException("This is an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(final Thread t, final Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
                System.out.print(String.format("%s, %s, %s%n", secretKey, t.getName(), e.getMessage()));
            }
        }
    }

}

