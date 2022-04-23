
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

public class Rentbook implements ActionListener {

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JTextField titlet = new JTextField();
	private JLabel titlel = new JLabel();
	private JTextField membert = new JTextField();
	private JLabel memberl = new JLabel();
	private JButton rent = new JButton();
	private JLabel labelprint = new JLabel();
	private JLabel labelmember = new JLabel();
	private JLabel labeltitle = new JLabel();

	
	public Rentbook()throws IOException {
		
		//file
		File file = new File("book.txt");
	    Scanner s = null;
		try {
			   s = new Scanner(file);
		}
	    catch (IOException e) {
	    	System.out.println(e);
	    }
		
		//window
		frame = new JFrame();
		frame.setSize(800, 500);
		
		//text
		titlel = new JLabel("Book Title: ");
		titlel.setBounds(50, 100, 200, 30);
		frame.add(titlel);
		titlet = new JTextField(20);
		titlet.setBounds(150, 100, 100, 30);
		frame.add(titlet);

		memberl = new JLabel("Member: ");
		memberl.setBounds(50, 150, 200, 30);
		frame.add(memberl);
		membert = new JTextField(20);
		membert.setBounds(150, 150, 100, 30);
		frame.add(membert);
		
		labeltitle = new JLabel("Book:  The Midnight Line,  " + 
				"The Rooster Bar,  " + 
				"Two Kinds of Truth,  " + 
				"Origin,  " + 
				"Artemis");
		labeltitle.setBounds(50, 30, 700, 30);
		frame.add(labeltitle);
		
		labelmember = new JLabel("Member: Alex, Gina, Mia, Pam, Elliot");
		labelmember.setBounds(50, 60, 500, 30);
		frame.add(labelmember);
		
		//button
		rent = new JButton("Rent");
		rent.addActionListener(this);
		rent.setBounds(50, 380, 150, 50);
		frame.add(rent);
		
		//
		labelprint = new JLabel("");
		labelprint.setBounds(50, 290, 450, 30);
		frame.add(labelprint);
		
		
		//color
		frame.setBackground(new Color(2,179,64));
		panel.setBackground(new Color(219,251,227));
		
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Rent Book");
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String member = membert.getText();
		String title = titlet.getText();
		
		//file
		String rentlist[] = null;
		Path filename = Paths.get("rent.txt");
	    try {
	      List<String> lines = Files.readAllLines(filename);
	      String allLines = String.join(",", lines);
	      rentlist = allLines.split(" ");
	    }
	    catch (IOException e1) {
	    	System.out.println(e1);	    	
	    }
	    
		String booklist[] = null;
		Path filenameb = Paths.get("book.txt");
	    try {
	      List<String> lines = Files.readAllLines(filenameb);
	      String allLines = String.join(",", lines);
	      booklist = allLines.split(",");
	    }
	    catch (IOException e1) {
	    	System.out.println(e1);	    	
	    }
	    
	    
		File file = new File("rent.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			
			for(int i=0;i<rentlist.length;i++) {
				out.write(rentlist[i]);
			}
			
			out.write(member+","+title+",");
			
			out.flush();
			out.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		File fileb = new File("book.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileb));
			
			for(int i=0;i<booklist.length;i++) {
				if(title.equals(booklist[i]))
				{
					int b = Integer.parseInt(booklist[i+4]);
					b=b-1;
					booklist[i+4] = String.valueOf(b);
				}
				out.write(booklist[i]+",");
			}
			
			out.flush();
			out.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		labelprint.setText(member+" has successfully rented "+title+"!");		
		
	}

}
