package task3008_chat_application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static ServerSocket serverSocket;
    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        final int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            ConsoleHelper.writeMessage("Server is running...");
            while(true) {
                final Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("The message couldn't be sent.");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(final Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                final Message message = connection.receive();
                if (message.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage("Wrong message type!");
                    continue;
                }
                final String userName = message.getData();
                if(userName.isEmpty() || connectionMap.containsKey(userName)) {
                    ConsoleHelper.writeMessage("The username is empty or already exists!");
                    continue;
                }
                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return userName;
            }
        }
    }
}

