import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchMember implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JTextField membert = new JTextField();
	private JLabel memberl = new JLabel();
	private JButton search = new JButton();
	private JLabel labelprintm = new JLabel();
	private JLabel labelmember = new JLabel();
	private JLabel labelrent = new JLabel();

	
	public SearchMember() throws IOException {
		
		//file
		String book[] = null;
		Path filename = Paths.get("book.txt");
	    try {

	    	List<String> lines = Files.readAllLines(filename);
	    	String allLines = String.join(" ", lines);
	    	book = allLines.split(" ");
	    }
	    catch (IOException e) {
	    	System.out.println(e);	    	
	    }
	    
	    String member[] = null;
		Path file = Paths.get("member.txt");
	    try {

	    	List<String> lines = Files.readAllLines(file);
	    	String allLines = String.join(" ", lines);
	    	member = allLines.split(" ");
	    }
	    catch (IOException e) {
	    	System.out.println(e);	    	
	    }
		
	    
		
		//window
		frame = new JFrame();
		frame.setSize(700, 500);
		
		//text
		memberl = new JLabel("Member: ");
		memberl.setBounds(50, 100, 200, 30);
		frame.add(memberl);
		membert = new JTextField(20);
		membert.setBounds(150, 100, 100, 30);
		frame.add(membert);
		
		labelmember = new JLabel("<html>Alex"+
				"<br> Gina "+
				"<br> Mia "+
				"<br> Pam "+
				"<br> Elliot</html>");
		labelmember.setBounds(500, 30, 100, 250);
		frame.add(labelmember);
		
		//button
		search = new JButton("Search");
		search.addActionListener(this);
		search.setBounds(50, 380, 150, 50);
		frame.add(search);
		
		//
		labelprintm = new JLabel("");
		labelprintm.setBounds(50, 330, 600, 30);
		frame.add(labelprintm);
		
		labelrent = new JLabel("");
		labelrent.setBounds(50, 250, 600, 100);
		frame.add(labelrent);
		
		//color
		frame.setBackground(new Color(115,0,153));
		panel.setBackground(new Color(255,170,255));
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Search Member");
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	    String member[] = null;
		Path file = Paths.get("member.txt");
	    try {

	    	List<String> lines = Files.readAllLines(file);
	    	String allLines = String.join(",", lines);
	    	member = allLines.split(",");
	    }
	    catch (IOException e1) {
	    	System.out.println(e1);	    	
	    }
	    
	    String rent[] = null;
		Path filer = Paths.get("rent.txt");
	    try {

	    	List<String> lines = Files.readAllLines(filer);
	    	String allLines = String.join(",", lines);
	    	rent = allLines.split(",");
	    }
	    catch (IOException e1) {
	    	System.out.println(e1);	    	
	    }
	    
		if(e.getSource() == search) {
			
			String membername = membert.getText();
			for(int i=0;i<member.length;i++)
			{
				if(membername.equals(member[i]))
				{
					for(int j=0;j<rent.length;j++) {
						if(membername.equals(rent[j])) {
							labelprintm.setText("First Name: "+member[i]+"  Last Name: "
									+member[i+1]+"  Email: "+member[i+2]+"  Phone Number: "+member[i+3]);
							labelrent.setText(membername+" has rented "+rent[j+1]);
							break;
						}
						else {
							labelprintm.setText("First Name: "+member[i]+"  Last Name: "
									+member[i+1]+"  Email: "+member[i+2]+"  Phone Number: "+member[i+3]);
							labelrent.setText("");
							break;
						}
					}
					break;
				}
				else {
					labelprintm.setText("The Member Cannot be found");
					labelrent.setText("");
				}
			}
		}
	}
}
