import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Update_Employee extends JFrame implements ActionListener, ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,l6,l7,emp;  // these are labels that are used in this frame
	JTextField t1,t2,t3,t4,t5,t6,t7; // 7 textfields used 
	JButton b1,b2;  // These are the two buttons used in this frame
	Choice choice1, choice2; //  this is the choice for selection
	
	public Update_Employee() {
		super("Update Employee");
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		choice2 = new Choice();
		choice2.setBounds(160, 40, 200, 20);
		
		try   // to retrieve empno to enter it into the choice/ fetching all the employee's id's
		{
			DbConn c1 = new DbConn();
			ResultSet rs = c1.s.executeQuery("select * from employee");
			
			while(rs.next())
			{
				choice2.add(rs.getString("id"));
			}
		}
		catch(Exception error) {}
		
		emp = new JLabel("Select Empno");
		emp.setBounds(40, 40, 100, 20);
		add(emp);
		add(choice2);
		
		l1 = new JLabel("Name : ");
		t1 = new JTextField(15);
		l1.setBounds(40, 80, 100, 20);
		t1.setBounds(160, 80, 200, 20);
		add(l1);
		add(t1);
		
		choice1 = new Choice();
		choice1.add("Male");
		choice1.add("Female");
		
		l2 = new JLabel("Gender : ");
		l2.setBounds(40, 120, 100, 20);
		choice1.setBounds(160, 120, 200, 20);
		add(l2);
		add(choice1);
		
		l3 = new JLabel("Address : ");
		t3 = new JTextField(15);
		l3.setBounds(40, 160, 100, 20);
		t3.setBounds(160, 160, 200, 20);
		add(l3);
		add(t3);
		
		l4 = new JLabel("State : ");
		t4 = new JTextField(15);
		l4.setBounds(40, 200, 100, 20);
		t4.setBounds(160, 200, 200, 20);
		add(l4);
		add(t4);
		
		l5 = new JLabel("City : ");
		t5 = new JTextField(15);
		l5.setBounds(40, 240, 100, 20);
		t5.setBounds(160, 240, 200, 20);
		add(l5);
		add(t5);
		
		l6 = new JLabel("Email : ");
		t6 = new JTextField(15);
		l6.setBounds(40, 280, 100, 20);
		t6.setBounds(160, 280, 200, 20);
		add(l6);
		add(t6);
		
		l7 = new JLabel("Phone : ");
		t7 = new JTextField(15);
		l7.setBounds(40, 320, 100, 20);
		t7.setBounds(160, 320, 200, 20);
		add(l7);
		add(t7);
		
		b1 =new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.setBounds(40,400,150,30);
        b2.setBounds(200,400,150,30);
        add(b1);
        add(b2);
		
        b1.addActionListener(this);
        b2.addActionListener(this);
        choice2.addItemListener(this);  // used to work with selective data
        
        setVisible(true);
        setSize(400,550);
        setLocation(600,200);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		try 
		{
			DbConn c1 = new DbConn();
//executing sql query to fetch the data selectively			
			ResultSet rs = c1.s.executeQuery("select * from employee where id="+choice2.getSelectedItem());
			if (rs.next())
			{
				t1.setText(rs.getString("name"));  //set text is the fucntion to set the values accordingly
				t3.setText(rs.getString("address"));
				t4.setText(rs.getString("state"));
				t5.setText(rs.getString("city"));
				t6.setText(rs.getString("email"));
				t7.setText(rs.getString("phone"));
			}
		}
		catch(Exception error)
		{
			error.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)  // if the button update is triggered
		{
			String name = t1.getText();
			String gender = choice1.getSelectedItem();
			String address = t3.getText();
			String state = t4.getText();
			String city = t5.getText();
			String email = t6.getText();
			String phone = t7.getText();
			
//executing sql query to update the data 			
			String query = "update employee set name='"+name+"',gender='"+gender+"', address='"+address+"',state='"+state+"',city='"+city+"',email='"+email+"', phone='"+phone+"' where id="+choice2.getSelectedItem();
			
			try
			{
				DbConn c1 = new DbConn();
				c1.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
				this.setVisible(false);
			}
			catch(Exception error) 
			{
				error.printStackTrace();
			}
		}
		if(e.getSource() == b2)  // if the button delete is trigerred
		{
			try 
			{
				DbConn c1 = new DbConn();
				
//executing sql query to delete the data
				c1.s.executeUpdate("delete from employee where id="+choice2.getSelectedItem());
				JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
				this.setVisible(false);
			} 
			catch (Exception error) 
			{
				error.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		
		new Update_Employee().setVisible(true);

	}

	

}
