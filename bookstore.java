
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class bookstore implements ActionListener{

	private JFrame frame = new JFrame();
	private JButton d = new JButton();
	private JButton s = new JButton();
	private JButton r = new JButton();
	private JButton sm = new JButton();

	private JPanel panel = new JPanel();	
	
	public bookstore() throws IOException {
		
		
		//window
	    frame = new JFrame();
		frame.setSize(300, 550);
		
		//button

		d = new JButton("Display Book List");
		d.addActionListener(this);
		d.setBounds(50, 100, 200, 50);
		frame.add(d);
		
		s = new JButton("Search the Book");
		s.addActionListener(this);
		s.setBounds(50, 200, 200, 50);
		frame.add(s);
		
		r = new JButton("Rent a Book");
		r.addActionListener(this);
		r.setBounds(50, 300, 200, 50);
		frame.add(r);
		
		sm = new JButton("Search Member");
		sm.addActionListener(this);
		sm.setBounds(50, 400, 200, 50);
		frame.add(sm);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		//color
		frame.setBackground(new Color(21,21,249));
		panel.setBackground(new Color(180,220,230));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Book Store");
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == d) {
			try {
				new Displaybook();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == s) {
			
			try {
				new Searchbook();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == r) {
			
			try {
				new Rentbook();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == sm) {
			
			try {
				new SearchMember();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}
