package smobs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {

	public static void main(String[] args) {
		Map<String, String> data = readData("socms.csv");
		
		for (String uri : data.keySet()) {
			System.out.println(uri+"  -  "+ data.get(uri));
			SocialMachinePage stub = new SocialMachinePage(data.get(uri), "http://"+uri);
			stub.generateStubText();			
		}
//		SocialMachinePage stub = new SocialMachinePage("Anonymous", "http://example.org/");
//		stub.generateStubText();
	}
	
	/*
	 * uri - name pairs
	 */
	private static Map<String, String> readData(String inputFile) {
		Map<String, String> lines = new HashMap<String, String>();
		
		BufferedReader br = null;
		String line;
		String splitBy = ",";
		try {
			br = new BufferedReader(new FileReader(inputFile));
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(splitBy);	 
				lines.put(parts[0], parts[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lines;
	}
}
