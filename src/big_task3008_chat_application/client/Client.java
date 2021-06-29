package big_task3008_chat_application.client;

import big_task3008_chat_application.*;

import java.io.IOException;
import java.net.Socket;

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

        public void run() {
            try {
                final String serverAddress = getServerAddress();
                final int serverPort = getServerPort();
                final Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " has joined the chat");
        }
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + "has left the chat");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized(Client.this) {
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while(true) {
                final Message received = connection.receive();
                if (received.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }
                else if (received.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while(true) {
                final Message received = connection.receive();
                if (received.getType() == MessageType.TEXT) {
                    processIncomingMessage(received.getData());
                }
                else if (received.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(received.getData());
                }
                else if (received.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(received.getData());
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }
}

