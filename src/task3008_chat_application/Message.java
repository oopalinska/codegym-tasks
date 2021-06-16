package task3008_chat_application;

import java.io.Serializable;

public class Message implements Serializable {
    private final MessageType type;
    private final String data;

    public Message(final MessageType messageType) {
        this.type = messageType;
        this.data = null;
    }

    public Message(final MessageType type, final String data) {
        this.type = type;
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}