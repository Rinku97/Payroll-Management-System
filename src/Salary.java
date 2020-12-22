import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Salary extends JFrame implements ActionListener, ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,l6, l7;  // these are 7 labels that are used in this frame
	JTextField t1,t2,t3,t4,t5,t6; // 7 textfields used 
	JButton b1,b2;  // These are the two buttons used in this frame
	Choice choice; //  this is the choice for selection
	
	public Salary() 
	{
		super("Set Salary");
		setSize(600, 500);
		setLocation(500, 200);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		choice = new Choice();
		
		setLayout(new GridLayout(8,2,20,20));  // this gridLayout is used for making forms and devides them in the form of rows and columns. (8,2,10,40) Here this 8 = no. of rows, 2 = no. of col, 10 and 40 is the spacing between the text fields and lines used.
		
		try
		{
			DbConn c1 = new DbConn();
			ResultSet rs = c1.s.executeQuery("select * from employee");
			
			while(rs.next()) // this will only jump to id coloumn
			{
				choice.add(rs.getString("id"));
			}
		}
		catch(Exception error) {}
		
// adding labels and text fields into the panel
		
		add(new JLabel("New Empno"));
		add(choice);
		
		l6 = new JLabel("Emp Name");
		t6 = new JTextField(15);
		add(l6);
		add(t6);
		
		l1 = new JLabel("HRA");
		t1 = new JTextField(15);
		add(l1);
		add(t1);
		
		l2 = new JLabel("DA");
		t2 = new JTextField(15);
		add(l2);
		add(t2);
		
		l3 = new JLabel("MED");
		t3 = new JTextField(15);
		add(l3);
		add(t3);
		
		l4 = new JLabel("PF");
		t4 = new JTextField(15);
		add(l4);
		add(t4);
		
		l5 = new JLabel("Basic Salary");
		t5 = new JTextField(15);
		add(l5);
		add(t5);
		
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }});
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		choice.addItemListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		try 
		{
			DbConn c1 = new DbConn();
//executing sql query to fetch the data selectively			
			ResultSet rs = c1.s.executeQuery("select * from employee where id="+choice.getSelectedItem());
			if (rs.next())
			{
				t6.setText(rs.getString("name"));  //set text is the fucntion to set the values accordingly
	
			}
		}
		catch(Exception error)
		{
			error.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String hra = t1.getText();
		String id = choice.getSelectedItem();
		String da = t2.getText();
		String med = t3.getText();
		String pf = t4.getText();
		String basicSalary = t5.getText();
// executing sql query to unsert data into table
		String query = "insert into salary values("+id+", "+hra+", "+da+", "+med+", "+pf+", "+basicSalary+")";
		
		try
		{
			DbConn c1 = new DbConn();
			c1.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Salary Updated Successfully");
			this.setVisible(false); // Shows or hides this Window depending on the value of parameter (true/false)
		}
		catch(Exception error)
		{	
			error.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Salary().setVisible(true);

	}

	

}
