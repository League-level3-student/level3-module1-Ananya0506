package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	ClockUtilities clockUtil;
	Timer timer;
	TimeZone timeZone;

	JFrame frame;
	JPanel panel;
	JTextArea textArea;
	JButton button = new JButton("add city");

	String city1;
	String city2;
	String city3;
	String city4;
	String city5;
	String dateStr;
	String timeStr;
	HashMap<String, TimeZone> worldClocks;
	CityData data = new CityData();

	public WorldClocks() {
		worldClocks = new HashMap<String, TimeZone>();
		clockUtil = new ClockUtilities();

		// The format for the city must be: city, country (all caps)
		frame = new JFrame();
		panel = new JPanel();
		panel.add(button);
		button.addActionListener(this);
		textArea = new JTextArea();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.add(panel);
		panel.add(textArea);
//    	for(int i=0; i<5; i++) {
//    	
//    	city1 = JOptionPane.showInputDialog("Enter a city and the corresponding country(abbreviation in all caps) to get its time zone info-- make sure the city is capitalized properly!");
//       
//       data.setName(city1);
//       
//       data.getCountry();
//    	
//    	
//        timeZone = clockUtil.getTimeZoneFromCityName(data.getName());
//        Calendar c = Calendar.getInstance(timeZone);
//        
//        System.out.println("Full date and time: " + c.getTime());
//        
//        Calendar calendar = Calendar.getInstance(timeZone);
//        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
//        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
//        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
//        
//        System.out.println(dateStr);
//    	
//        // Sample starter program
//        // THE LINE BELOW IS WHERE THE PROBLEM ISSSSSS
//       panel.add(textArea);
		// textArea.setText(s + "\n" + dateStr);

		// This Timer object is set to call the actionPerformed() method every
		// 1000 milliseconds
		timer = new Timer(1000, this);
		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == timer) {

//			Calendar c = Calendar.getInstance(timeZone);
//			String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
//					+ c.get(Calendar.SECOND);
//			String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
//					+ c.get(Calendar.SECOND) + "]";
//			timeStr = militaryTime + twelveHourTime;
//
//			System.out.println(timeStr);
//			textArea.setText(data.getName() + "\n" + dateStr + "\n" + timeStr);
//			frame.pack();
			textArea.setText("");
			for(String s: worldClocks.keySet()) { 
			
					TimeZone timeZone = worldClocks.get(s);
					Calendar c = Calendar.getInstance(timeZone);
					String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
							+ c.get(Calendar.SECOND);
					String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
							+ c.get(Calendar.SECOND) + "]";
					timeStr = militaryTime + twelveHourTime;
					 String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
			        String dayOfWeek = c.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
			        dateStr = dayOfWeek + " " + month + " " + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR);
			        textArea.setText(textArea.getText() + "\n\n" + s + "\n"+ dateStr + "\n" + timeStr);
			        frame.pack();
			        
				
			}
			
			
		} else {
			city1 = JOptionPane.showInputDialog("Enter a city and the corresponding country(abbreviation in all caps)"
					+ " to get its time zone info-- make sure the city is capitalized properly!");
			timeZone = clockUtil.getTimeZoneFromCityName(city1);
			
			worldClocks.put(city1, timeZone);

		}
	}
}
