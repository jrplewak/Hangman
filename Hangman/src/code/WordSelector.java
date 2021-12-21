package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordSelector {

	public WordSelector() {
		
	}
	
	private ArrayList<String> readDictionary(){
		ArrayList<String> validWords = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/words.txt"));
			String line = reader.readLine();
			while (line != null) {
				line = reader.readLine();
                if (line == null) {
                	break;
                }
				if( line.length() >10 || line.length() < 3) {
                	continue;
                }
				validWords.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return validWords;
	}
	
	public String getWord() {	
		Random r = new Random();
		int index = Math.abs(r.nextInt(50)) % readDictionary().size();
		ArrayList<String> validWords = readDictionary();
		String word = validWords.get(index);
		System.out.println(word); //keep in for now for debug
		
		return word;
	}
}
