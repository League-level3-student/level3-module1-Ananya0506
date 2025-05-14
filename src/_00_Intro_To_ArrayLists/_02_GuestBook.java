package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();	
	ArrayList<String> names = new ArrayList<String>();
	
    public static void main(String[] args) {
	
    	new _02_GuestBook().run();
    	
    }

	private void run() {
		
		f.add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		p.add(b1);
		p.add(b2);
		f.pack();
		b1.setText("Add Name");
		b2.setText("View Names");
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== b1) {
			String newName = JOptionPane.showInputDialog("Enter a name");
			names.add(newName);
	}
		if (e.getSource() == b2) {
			JOptionPane.showMessageDialog(null, "Bob Banders \n Sandy SUmmers \n Greg Ganders \n Donny Doners \n " + names);
		}
	}
}
