import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class New_Employee extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,l6,l7;  // these are 7 labels that are used in this frame
	JTextField t1,t2,t3,t4,t5,t6,t7; // 7 textfields used 
	JButton b1,b2;  // These are the two buttons used in this frame
	Choice c1; //  this is the choice for selection
	
	public New_Employee()
	{
		super("New Employee");
		setSize(700, 700);
		setLocation(600, 200);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel p1 = new JPanel();   // this is awt component which is a lightweight container
		p1.setBackground(Color.WHITE);  // panel Background Color
		p1.setLayout(new GridLayout(8,2,10,40));  // this gridLayout is used for making forms and devides them in the form of rows and columns. (8,2,10,40) Here this 8 = no. of rows, 2 = no. of col, 10 and 40 is the spacing between the text fields and lines used.
		
// adding all the labels and textfields to the panel
		l1 = new JLabel("Name");
		t1 = new JTextField(15);
		p1.add(l1);   //  adding labels and the textfields into the panel
		p1.add(t1);
		
		c1 = new Choice();
		c1.add("Male");
		c1.add("Female");
		
		l2 = new JLabel("Gender");
		p1.add(l2);
		p1.add(c1);
		
		l3 = new JLabel("Address");
		t3 = new JTextField(15);
		p1.add(l3);
		p1.add(t3);
		
		l4 = new JLabel("State");
		t4 = new JTextField(15);
		p1.add(l4);
		p1.add(t4);
		
		l5 = new JLabel("City");
		t5 = new JTextField(15);
		p1.add(l5);
		p1.add(t5);
		
		l6 = new JLabel("Email");
		t6 = new JTextField(15);
		p1.add(l6);
		p1.add(t6);
		
		l7 = new JLabel("Phone");
		t7 = new JTextField(15);
		p1.add(l7);
		p1.add(t7);
		
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		p1.add(b1);
		p1.add(b2);
		
		setLayout(new BorderLayout()); //  borderlayout arranges the componenets in the five regions that is North, South, East, West, Center
		add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.png"))), "West");
		add(p1, "Center");
		
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }});
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String name = t1.getText(); // getText function is used to retrieve the value present in the textfield
		String selectGender = c1.getSelectedItem(); // this function is used for the choice where more than one value is used for the selction purpose from the textfield
		String address = t3.getText();
		String state = t4.getText();
		String city = t5.getText();
		String email = t6.getText();
		String phone = t7.getText();
		
// executing sql query to insert the data into the table
		String query = "insert into employee values(null, '"+name+"', '"+selectGender+"', '"+address+"', '"+state+"', '"+city+"','"+email+"','"+phone+"' )";
		try
		{
			DbConn c1 = new DbConn();
			c1.s.executeUpdate(query);  // to insert the values into the table
			JOptionPane.showMessageDialog(null, "Employee Created Successfully");
			this.setVisible(false);
		}
		catch(Exception error) 
		{
			error.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		new New_Employee().setVisible(true);
	
	}
	
}
