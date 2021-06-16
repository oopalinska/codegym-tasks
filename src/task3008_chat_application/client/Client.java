package task3008_chat_application.client;

import task3008_chat_application.*;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        final SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized(this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("An error occured");
            return;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Connection established. To exit, enter 'exit'.");
        } else {
            ConsoleHelper.writeMessage("An error occurred while working with the client.");
        }
        while (clientConnected) {
            final String s = ConsoleHelper.readString();
            if (s.equalsIgnoreCase("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(s);
            }
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Please enter the server address");
        return ConsoleHelper.readString();
    }
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Please enter the server port");
        return ConsoleHelper.readInt();
    }
    protected String getUserName() {
        ConsoleHelper.writeMessage("Please enter the username");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole() {
        return true;
    }
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            Server.sendBroadcastMessage(new Message(MessageType.USER_REMOVED, this.getUserName()));
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread {

    }
}
