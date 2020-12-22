import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class project extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public project()
	{
		super("Payroll System");
		setSize(2000, 1100);  // This is the size of the frame;
		getContentPane().setBackground(Color.WHITE); // This(getContentPane) will make the background color of the frame to a specific color
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pay5.png"));
		Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT); // Setting size of the image
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		add(l1);  // adding label onto the frame
		
		JMenuBar menuBar = new JMenuBar(); // For Creating the Menu Bar
		setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File"); // For Cretaing The Menu
		file.setForeground(Color.BLACK);
		
		JMenuItem newEmp = new JMenuItem("New Employee");
		newEmp.setForeground(Color.BLACK);
		newEmp.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		newEmp.setMnemonic('N');
		newEmp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newEmp.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/New.png")));
		
		JMenuItem salary = new JMenuItem("Salary");
		salary.setForeground(Color.BLACK);
		salary.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		salary.setMnemonic('S');
		salary.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		salary.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.png")));
		
		JMenuItem listEmp = new JMenuItem("List Employee");
		listEmp.setForeground(Color.BLACK);
		listEmp.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		listEmp.setMnemonic('L');
		listEmp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		listEmp.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));
		
// Adding these menuitems into the menu and then menubar
		
		file.add(newEmp);
		file.add(salary);
		file.add(listEmp);
		menuBar.add(file);
		
		newEmp.addActionListener(this);
		salary.addActionListener(this);
		listEmp.addActionListener(this);
		
		JMenu update = new JMenu("Update"); // For Cretaing The Menu
		update.setForeground(Color.BLACK);
		
		JMenuItem updateSal = new JMenuItem("Update Salary"); // For creating the menuitems
		updateSal.setForeground(Color.BLACK);
		updateSal.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		updateSal.setMnemonic('U');
		updateSal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		updateSal.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/EditOpen.png")));
		
		JMenuItem updateEmp = new JMenuItem("Update Employee");
		updateEmp.setForeground(Color.BLACK);
		updateEmp.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		updateEmp.setMnemonic('P');
		updateEmp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		updateEmp.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
		
		JMenuItem attendence = new JMenuItem("Take Attendence");
		attendence.setForeground(Color.BLACK);
		attendence.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		attendence.setMnemonic('T');
		attendence.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		attendence.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.PNG")));
		
// Adding these menuitems into the menu and then menubar
		
		update.add(updateSal);
		update.add(updateEmp);
		update.add(attendence);
		menuBar.add(update);
		
		updateSal.addActionListener(this);
		updateEmp.addActionListener(this);  
		attendence.addActionListener(this);
		
		JMenu reports = new JMenu("Reports"); // For Cretaing The Menu
		reports.setForeground(Color.BLACK);
		
		JMenuItem payslip = new JMenuItem("Generate Payslip");
		payslip.setForeground(Color.BLACK);
		payslip.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		payslip.setMnemonic('P');
		payslip.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		payslip.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
		
		JMenuItem listAttendence = new JMenuItem("List Attendence");
		listAttendence.setForeground(Color.BLACK);
		listAttendence.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		listAttendence.setMnemonic('L');
		listAttendence.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		listAttendence.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
		
// Adding these menuitems into the menu and then menubar
		
		reports.add(payslip);
		reports.add(listAttendence);
		menuBar.add(reports);
		
		payslip.addActionListener(this);
		listAttendence.addActionListener(this);
		
		JMenu utilities = new JMenu("Utilities"); // For Cretaing The Menu
		utilities.setForeground(Color.BLACK);
		
		JMenuItem notepad = new JMenuItem("Notepad");
		notepad.setForeground(Color.BLACK);
		notepad.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		notepad.setMnemonic('O');
		notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		notepad.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/New.png")));
		
		JMenuItem calculator = new JMenuItem("Calculator");
		calculator.setForeground(Color.BLACK);
		calculator.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		calculator.setMnemonic('C');
		calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		calculator.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
		
		JMenuItem webBrowser = new JMenuItem("Web Browser");
		webBrowser.setForeground(Color.BLACK);
		webBrowser.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		webBrowser.setMnemonic('E');
		webBrowser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		webBrowser.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));
		
// Adding these menuitems into the menu and then menubar
		
		utilities.add(notepad);  
		utilities.add(calculator);
		utilities.add(webBrowser);
		menuBar.add(utilities);
		
		notepad.addActionListener(this);
		calculator.addActionListener(this);
		webBrowser.addActionListener(this);
		
		JMenu exit = new JMenu("Exit"); // For Cretaing The Menu
		exit.setForeground(Color.BLACK);
		
		JMenuItem quit = new JMenuItem("Exit");
		quit.setForeground(Color.BLACK);
		quit.setFont(new Font("JetBrains Mono Regular", Font.PLAIN, 12));
		quit.setMnemonic('X');
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		quit.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
		
		exit.add(quit);
		menuBar.add(exit);
		
		quit.addActionListener(this); // to perform action
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String msg = e.getActionCommand();  // this is the function which returns a string 
		System.out.println(msg);
		if(msg.equals("New Employee"))
			new New_Employee().setVisible(true);
		else if(msg.equals("List Employee"))
			new List_Employee().setVisible(true);
		else if(msg.equals("Update Employee"))
			new Update_Employee().setVisible(true);
		else if(msg.equals("Salary"))
			new Salary().setVisible(true);
		else if(msg.equals("Update Salary"))
			new Update_Salary().setVisible(true);
		else if(msg.equals("Notepad"))
		{
			try
			{
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception error) { }
		}
		else if(msg.equals("Calculator"))
		{
			try
			{
				Runtime.getRuntime().exec("calc.exe");
			}
			catch(Exception error) { }
		}
		else if(msg.equals("Web Browser"))
		{
			try
			{
				Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			}
			catch(Exception error) { }
		}
		else if(msg.equals("Take Attendence"))
			new Take_Attendence().setVisible(true);
		else if(msg.equals("Exit"))
			dispose();
		else if(msg.equals("Generate Payslip"))
			new Pay_Slip().setVisible(true);
		else if(msg.equals("List Attendence"))
			new List_Attendence().setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new project().setVisible(true);

	}

}
