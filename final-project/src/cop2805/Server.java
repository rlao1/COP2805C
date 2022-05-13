package cop2805;
import java.net.*;
import java.io.*;
import java.nio.charset.*;

public class Server {
	
	public static void main(String[] args) {
		WordSearcher searcher = new WordSearcher("hamlet.txt");
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(1236);
			
			while(true) {
				Socket client = server.accept();
				InputStream input = client.getInputStream();
				OutputStream output = client.getOutputStream();
				
				int n = input.read();
				byte[] data = new byte[n];
				input.read(data);
				String clientInput = new String(data, StandardCharsets.UTF_8);
				
				for(int i : searcher.search(clientInput)) {
					String response = String.valueOf(i) + '\n';
					output.write(response.getBytes());
				}
				
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
