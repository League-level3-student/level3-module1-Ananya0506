package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();

	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	 HashMap<Integer, String> ppl = new HashMap<Integer, String>();
	public void setup() {

b1.setText("Add Entry");
b2.setText("Search by ID");
b3.setText("View List");
b4.setText("Remove Entry");

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

panel.add(b1);
panel.add(b2);
panel.add(b3);
panel.add(b4);
frame.add(panel);
frame.pack();
frame.setVisible(true);

}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== b1) {
			String num = JOptionPane.showInputDialog("gimme an ID number");
			int ID = Integer.parseInt(num);
			String name = JOptionPane.showInputDialog("gimme a name");
			ppl.put(ID, name);
		}
		if(e.getSource()== b2) {
			String nummy = JOptionPane.showInputDialog("gimme the ID u want");
			int numnum = Integer.parseInt(nummy);
			if (ppl.keySet().contains(numnum)) { 
			System.out.print("The person at # " + numnum + " is: ");
		        System.out.println(ppl.get(numnum));
			}
			else {
				JOptionPane.showMessageDialog(null, "that ID doesn't exist");
			}
			
		}
		if(e.getSource()== b3) {
			 System.out.println("\nAll the key-value pairs:");
		        for(Integer i : ppl.keySet()){
		            System.out.println("key: " + i + ", value: " + ppl.get(i));
		        }
		}	
		if(e.getSource()== b4) {
			String numm = JOptionPane.showInputDialog("gimme the ID to remove");
			int numnumnum = Integer.parseInt(numm);
			if (ppl.keySet().contains(numnumnum)) { 
			ppl.keySet().remove(numnumnum);
			}
			else {
				JOptionPane.showMessageDialog(null, "that ID doesn't exist");
			}
}
		
		
	}
	
	public static void main(String[] args) {
		_02_LogSearch logsearch = new _02_LogSearch();
		logsearch.setup();
	}
	
}