package com.mindlinksoft;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Handler {
	private final Conversation conversation;
	
	public Handler(String file) throws FileNotFoundException, IOException {

        try(InputStream is = new FileInputStream(file);
            BufferedReader r = new BufferedReader(new InputStreamReader(is))) {

            List<Message> messages = new ArrayList<>();

            String conversationName = r.readLine();
            String line;

            while ((line = r.readLine()) != null) {
                String[] split = line.split(" ", 3);

                messages.add(new Message(Instant.ofEpochSecond(Long.parseUnsignedLong(split[0])), split[1], split[2]));
            }
            
            this.conversation = new Conversation(conversationName, messages);
        }
	}
	
	public void search(String args) {
		Search s = new Search(args, conversation);
		
		s.search();
	}	
	
	public void searchDate(String[] args) throws ParseException {
		Instant[] dates = new Instant[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		for(int i = 0; i < args.length; i++) {
			Date date = sdf.parse(args[i]);
			long epoch = date.getTime();
			dates[i] = Instant.ofEpochMilli(epoch);
		}
		
		if(dates[0].isAfter(dates[1])) {
			Instant temp = dates[1];
			dates[1] = dates[0];
			dates[0] = temp;
		}
		Search s = new Search(dates, conversation);
		s.searchDates();
	}
}
