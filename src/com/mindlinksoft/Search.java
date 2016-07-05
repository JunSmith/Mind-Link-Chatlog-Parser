package com.mindlinksoft;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Search {
	private String[] searchTerm;
	private Instant[] searchDates;
	private final Conversation conversation;
	
	public Search(String args, Conversation conversation) {		
		this.searchTerm = args.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		this.conversation = conversation;
	}
	
	public Search(Instant[] args, Conversation conversation) {
		this.searchDates = args;
		this.conversation = conversation;
	}
	
	public List<Message> search() {
		List<Message> results = new ArrayList<Message>();
		
		for (Message m : conversation.getMessages()) {
			for(String term : searchTerm) {
				if(m.getPunctLess().contains(term)) {
					results.add(m);
					System.out.println(m.toString());
				}
			}
		}
		
		return results;
	}
	
	public List<Message> searchDates() {
		List<Message> results = new ArrayList<Message>();
		
		for(Message m : conversation.getMessages()) {
			Instant time = m.getTimestamp();
			if (time.isAfter(searchDates[0]) && time.isBefore(searchDates[1])) {
				results.add(m);
				System.out.println(m.toString());
			}
		}
		
		return results;
	}
}
