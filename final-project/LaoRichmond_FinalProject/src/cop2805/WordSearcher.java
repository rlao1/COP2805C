package cop2805;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordSearcher {
	List<String> lines = new ArrayList<String>();
	
	public WordSearcher(String filename) {
		try {
			lines = Files.readAllLines(Paths.get(filename));
			lines.replaceAll(String::toUpperCase);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> search(String w) {
		List<Integer> position = new ArrayList<Integer>();
		String word = w.toUpperCase();
		
		for(int i = 0; i < lines.size(); i++) {
			String str = lines.get(i);
			if(str.indexOf(word) >= 0) position.add(i);
		}
		return position;
	}
}