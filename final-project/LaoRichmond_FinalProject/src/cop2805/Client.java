package cop2805;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {
	JTextField query = new JTextField("To be, or not to be");
	DefaultListModel<Integer> listModel = new DefaultListModel<Integer>();
	JList<Integer> result = new JList<Integer>(listModel);
	JButton transmitBtn = new JButton("Transmit");
	JScrollPane scrollPane = new JScrollPane();
	GridBagConstraints gbc = new GridBagConstraints();
	
	private void init() {
		setLayout(new GridBagLayout());
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridx = 0; gbc.gridy = 0;
		add(new JLabel("Word to search: "), gbc);
		
		gbc.gridx = 2; gbc.gridy = 0;
		gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
		add(query, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		add(new JLabel("Results: "), gbc);
		
		gbc.gridx = 2; gbc.gridy = 1;
		gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
		scrollPane.setViewportView(result);
		result.setLayoutOrientation(JList.VERTICAL);
		add(scrollPane, gbc);
		
		gbc.gridx = 1; gbc.gridy = 2;
		transmitBtn.addActionListener(new ClientActionListener(this));
		add(transmitBtn, gbc);

	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Client frame = new Client();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setTitle("Word Search");
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 350);
		frame.setLocation((int) screenSize.getWidth()/3, (int) screenSize.getHeight()/3);
		frame.init();
		
		try {
			String userString = frame.query.getText();
			Socket connection = new Socket("127.0.0.1", 1236);
			OutputStream output = connection.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			output.write(userString.length());
			output.write(userString.getBytes());
			
			String response = "";
			while(response != null) {
				response = reader.readLine();
				if(response != null) frame.listModel.addElement(Integer.parseInt(response));
			}

			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class ClientActionListener implements ActionListener {
	Client frame;
	
	public ClientActionListener(Client fr) {
		frame = fr;
	}
	
	public void actionPerformed(ActionEvent a) {
		frame.listModel.clear();
		try {
			String userString = frame.query.getText();
			Socket connection = new Socket("127.0.0.1", 1236);
			OutputStream output = connection.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			output.write(userString.length());
			output.write(userString.getBytes());
			
			String response = "";
			while(response != null) {
				response = reader.readLine();
				if(response != null) frame.listModel.addElement(Integer.parseInt(response));
			}

			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
