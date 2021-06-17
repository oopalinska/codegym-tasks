package task3008_chat_application.client;

import task3008_chat_application.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        Client client = new BotClient();
        client.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            introduceYourself();
            super.clientMainLoop();
        }

        private void introduceYourself() {
            sendTextMessage("Hello, there. I'm a bot. I understand the following commands: " +
                    "date, day, month, year, time, hour, minutes, seconds.");
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String[] split = message.split(": ");
            if (split.length != 2) {
                return;
            }
            String text = split[1];
            if (text.equalsIgnoreCase("hey") || text.equalsIgnoreCase("hello") || text.equalsIgnoreCase("hi")) {
                introduceYourself();
            }
            String format = null;
            switch (text) {
                case "date":
                    format = "d.MM.YYYY";
                    break;
                case "day":
                    format = "d";
                    break;
                case "month":
                    format = "MMMM";
                    break;
                case "year":
                    format = "YYYY";
                    break;
                case "time":
                    format = "H:mm:ss";
                    break;
                case "hour":
                    format = "H";
                    break;
                case "minutes":
                    format = "m";
                    break;
                case "seconds":
                    format = "s";
                    break;
            }

            if (format != null) {
                String answer = new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
                BotClient.this.sendTextMessage("Information for " + split[0] + ": " + answer);
            }
        }
    }
}
