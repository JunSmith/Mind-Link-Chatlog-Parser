package com.mindlinksoft.Runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import com.mindlinksoft.Handler;

public class Runner {

	public static void main(String[] args) {
		try {
			Handler handler = new Handler(args[0]);
			switch(args[1]) {
				case "-s": 
					handler.search(args[2]);
					break;			
			
				case "-d": 
					String[] dates = new String[]{ args[2], args[3]};
					handler.searchDate(dates);
					break;
				
				default:
					break;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error - File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error - Unable to read file");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error - Not enough arguments provided. A file name followed by a flag then the search term is needed");
			System.out.println("For a string: -s \"test string\" ");
			System.out.println("For dates: -d \"1970/01/01 00:00:00\" \"1970/01/01 00:00:01\"");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Error - Worng format provided. Be sure to follow the examples provided");
			System.out.println("For a string: -s \"test string\" ");
			System.out.println("For dates: -d \"1970/01/01 00:00:00\" \"1970/01/01 00:00:01\"");
			e.printStackTrace();
		}
	}
}