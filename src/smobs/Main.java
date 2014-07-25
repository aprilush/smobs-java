package smobs;

import java.util.HashMap;
import java.util.Map;


public class Main {

	public static void main(String[] args) {
		Map<String, String> data = readData(args[1]);
		
		for (String uri : data.keySet()) {
			
		}
		SocialMachinePage stub = new SocialMachinePage("Anonymous", "http://example.org/");
		stub.generateStubText();
	}
	
	/*
	 * uri - name pairs
	 */
	private static Map<String, String> readData(String inputFile) {
		return new HashMap<String, String>();
	}
}
