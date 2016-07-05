package com.mindlinksoft;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Message {

    private final String content;
    private final String sender;
    private final Instant timestamp;
    private final List<String> punctLess;

    public Message(Instant timestamp, String sender, String content) {
        this.timestamp = timestamp;
        this.sender = sender;
        this.content = content;
        
        List<String> all = new ArrayList<String>();
        all.add(this.sender);
        all.addAll(Arrays.asList(content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+")));
        this.punctLess = all;
    }

    public String getContent() {
        return this.content;
    }

    public String getSender() {
        return this.sender;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }
    
    public List<String> getPunctLess() {
    	return this.punctLess;
    }
    
    public String toString() {
    	String out;
    	
    	out = timestamp.toString() + " - " + sender + " - " + content;
    	
    	return out;
    }
}
