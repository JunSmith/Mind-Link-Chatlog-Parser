package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import com.mindlinksoft.*;

public class MainTest {
	
	@Test
	public void testEmptySearch() throws FileNotFoundException, IOException {
		String[] args = new String[]{"res/chat.txt", "-s", ""};
		Handler handler = new Handler(args[0]);
		handler.search(args[2]);
	}
	
	@Test
	public void testReverseDateSearch() throws FileNotFoundException, IOException, ParseException {
		String[] args = new String[]{"res/chat.txt", "-d", "\"2015/11/25 17:01:49\" \"2015/11/25 17:01:56\""};
		Handler handler = new Handler(args[0]);
		String[] dates = new String[]{ args[3], args[2]};
		handler.searchDate(dates);
	}
	
	@Test
	public void testEmptyDateSearch() throws FileNotFoundException, IOException, ParseException {
		String[] args = new String[]{"res/chat.txt", "-d", ""};
		Handler handler = new Handler(args[0]);
		String[] dates = new String[]{ args[2], args[2]};
		handler.searchDate(dates);
	}

}
