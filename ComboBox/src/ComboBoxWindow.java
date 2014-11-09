import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import static java.util.Calendar.*;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class ComboBoxWindow {

	private JComboBox comboBox_1 = new JComboBox();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBoxWindow window = new ComboBoxWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComboBoxWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Calendar c = Calendar.getInstance();
		int dayNow = c.get(DAY_OF_MONTH);
		int monthNow = c.get(MONTH);
		int yearNow = c.get(YEAR);
		
		String[] years = new String[11];
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; 
		
		
		years[5] = Integer.toString(yearNow);
		int y = 1;
		for(int x = 4; x >= 0; x--)
		{
			
			years[x] = Integer.toString(yearNow - y);
			y = y + 1;
		}
		for(int z = 1; z <= 5; z++)
		{
			years[z + 5] = Integer.toString(yearNow + z);
		}
		
		
		JComboBox comboBox = new JComboBox(months);
		comboBox.setBounds(10, 11, 97, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(monthNow);
		
		

		comboBox_1.setBounds(10, 42, 97, 20);
		frame.getContentPane().add(comboBox_1);
		days(comboBox.getSelectedIndex(),comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(years);
		comboBox_2.setBounds(10, 73, 97, 20);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.setSelectedIndex(5);
		comboBox_1.setSelectedIndex(dayNow - 1);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(117, 14, 46, 14);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(117, 45, 46, 14);
		frame.getContentPane().add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(117, 76, 46, 14);
		frame.getContentPane().add(lblYear);
		
		
		comboBox.addActionListener(new ActionListener() 
		{
			
		      public void actionPerformed(ActionEvent actionEvent) 
		      {
		    	JComboBox comboBox = (JComboBox) actionEvent.getSource();
		    	int selectedmonth = comboBox.getSelectedIndex();
		    	comboBox_1.removeAllItems();
		    	days(comboBox.getSelectedIndex(),comboBox_1);
		    	  
		      }});
		      
		
		
		
		
		
		
		
		
		
	}
	public static void days(int selectedMonth, JComboBox comboBox_1)
	{
		Calendar c = Calendar.getInstance();
		selectedMonth = selectedMonth;
		
		
		if(selectedMonth == 0 || selectedMonth == 2 || selectedMonth == 4 || selectedMonth == 6 || selectedMonth == 7 || selectedMonth == 9 || selectedMonth == 11)
		{
			for(int a = 1; a <= 31; a++)
			{
				
				comboBox_1.addItem(Integer.toString(a));
			}
		}
		else if(selectedMonth == 1)
		{
			for(int d = 1; d <= 28; d++)
			{
				
				comboBox_1.addItem(Integer.toString(d));
			}
		}
		else if(selectedMonth == 3 || selectedMonth == 5 || selectedMonth == 8 || selectedMonth == 10)
		{
			for(int b = 1; b <= 30; b++)
			{
				
				comboBox_1.addItem(Integer.toString(b));
			}
		}
		
	}
}
