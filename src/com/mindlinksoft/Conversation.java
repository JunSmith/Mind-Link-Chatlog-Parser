package com.mindlinksoft;

import java.util.List;

public class Conversation {
    private final String name;

    private final List<Message> messages;

    public Conversation(String name, List<Message> messages) {
        this.name = name;
        this.messages = messages;
    }

    public String getName() {
        return this.name;
    }

    public List<Message> getMessages() {
        return this.messages;
    }
}
