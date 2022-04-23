import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import javax.swing.JTextField;

public class Searchbook implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JTextField titlet = new JTextField();
	private JLabel titlel = new JLabel();
	private JButton search = new JButton();
	private JLabel labelprint = new JLabel();
	private JLabel labeltitle = new JLabel();

	public Searchbook() throws IOException {
		
		
		//window
		frame = new JFrame();
		frame.setSize(800, 500);
		
		//text
		titlel = new JLabel("Book Title: ");
		titlel.setBounds(50, 100, 200, 30);
		frame.add(titlel);
		titlet = new JTextField(20);
		titlet.setBounds(250, 100, 100, 30);
		frame.add(titlet);
		
		labeltitle = new JLabel("<html>The Midnight Line  "+
				"<br>The Rooster Bar  " + 
				"<br>Two Kinds of Truth  " + 
				"<br>Origin  " + 
				"<br>Artemis</html>");
		labeltitle.setBounds(500, 30, 300, 300);
		frame.add(labeltitle);
		
		//button
		search = new JButton("Search");
		search.addActionListener(this);
		search.setBounds(50, 380, 150, 50);
		frame.add(search);
		
		//
		labelprint = new JLabel("");
		labelprint.setBounds(50, 330, 750, 30);
		frame.add(labelprint);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		//color
		frame.setBackground(new Color(230,0,92));
		panel.setBackground(new Color(255,147,147));
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Search Books");
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 String book[] = null;
			Path file = Paths.get("book.txt");
		    try {
		    	List<String> lines = Files.readAllLines(file);
		    	String allLines = String.join(",", lines);
		    	book = allLines.split(",");
		    }
		    catch (IOException e1) {
		    	System.out.println(e1);
		    }
			if(e.getSource() == search) {
				
				String membername = titlet.getText();
				for(int i=0;i<book.length;i++)
				{
					if(membername.equals(book[i]))
					{
						labelprint.setText("Title: "+book[i]+"  Author: "
								+book[i+1]+"  Number of pages: "+book[i+2]+"  Publisher: "+book[i+3]
										+"  Copies in the inventory:"+book[i+4]);
						break;
					}
					else {
						labelprint.setText("The Book Cannot be found");
					}
				}
			}
	}
}
