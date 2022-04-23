
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Displaybook{

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel labelbook = new JLabel();

	
	public Displaybook() throws IOException {
		
		//window
		frame = new JFrame();
		frame.setSize(500, 500);
		
		//file
		String book[] = null;
		Path filename = Paths.get("book.txt");
	    try {
	    	
	    	List<String> lines = Files.readAllLines(filename);
	    	String allLines = String.join("", lines);
	    	book = allLines.split(",");
	    }
	    catch (IOException e) {
	    	System.out.println(e);	    	
	    }
		
		//display
		labelbook = new JLabel();
		labelbook.setBounds(50, 30, 450, 470);
		frame.add(labelbook);
		
		String bookl[] = new String[book.length/5];
		
		for(int j=0;j<5;j++) {
			for(int i=5;i<book.length;i=i*5) {
				bookl[j] = book[i*j]+" , "+book[i*j+1]+" , "+
				book[i*j+2]+" , "+book[i*j+3]+" , "+book[i*j+4];
			}
		}
		
		
		labelbook.setText("<html>"+
				"<br>"+bookl[0]+"<br>"+bookl[1]+"<br>"+
				bookl[2]+"<br>"+bookl[3]+"<br>"+bookl[4]+"</html>");
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		//color
		frame.setBackground(new Color(228,184,3));
		panel.setBackground(new Color(237,221,158));
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Display Books");
		frame.add(panel);
		frame.setVisible(true);
		
	}

}
