
public class ExtraCode {

}

/*
Update Salary Class File full code default

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Update_Salary extends JFrame implements ActionListener, ItemListener{  //ItemListner is used to automatically fetched the data according to specific command. This is also the example of Multiple Inheritance in java through interfaces.
	
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,l6;  // these are labels that are used in this frame
	JTextField t1,t2,t3,t4,t5,t6; // 7 textfields used 
	JButton b1,b2;  // These are the two buttons used in this frame
	Choice choice; //  this is the choice for selection
	
	public Update_Salary() {
		
		super("Update Salary");  // super is the first method in the constructor to be called first and it is here used for providing the headin to the frame
		
		setLayout(null); // this layout is null because we donot want ot use nay of the default Layouts, we will give our own co-ordintaes for x and y.
		choice  = new Choice();

		try 
		{
			// this block is used to select a particulary field that is id or unique identifier to select individually
			DbConn c1 = new DbConn();
			ResultSet rs = c1.s.executeQuery("select * from salary");
			while(rs.next())
			{
				choice.add(rs.getString("id"));
			}
		}
		catch(Exception error) {}
		
// setBound is the function which is used when we donot have nay default Layout. It requires four Parameters x,y,width,height
// Parameters:x the new x-coordinate of this componenty, the new y-coordinate of this component, width the new width of this component, height the new height of this component		
		
		JLabel emp = new JLabel("Select Empno");
		emp.setBounds(20,20,100,20);
		add(emp);
		
		choice.setBounds(120,20,200,20);
		add(choice);
		
		l1 = new JLabel("HRA");
		t1 = new JTextField(15);
		l1.setBounds(20,60,100,20);
        t1.setBounds(120,60,200,20);
		add(l1);
		add(t1);
		
		l2 = new JLabel("DA");
		t2 = new JTextField(15);
		l2.setBounds(20,100,100,20);
        t2.setBounds(120,100,200,20);
		add(l2);
		add(t2);
		
		l3 = new JLabel("MED");
		t3 = new JTextField(15);
		l3.setBounds(20,140,100,20);
        t3.setBounds(120,140,200,20);
		add(l3);
		add(t3);
		
		l4 = new JLabel("PF");
		t4 = new JTextField(15);
		l4.setBounds(20,180,100,20);
        t4.setBounds(120,180,200,20);
		add(l4);
		add(t4);
		
		l5 = new JLabel("Basic Salary");
		t5 = new JTextField(15);
		l5.setBounds(20,220,100,20);
        t5.setBounds(120,220,200,20);
		add(l5);
		add(t5);
		
		b1 =new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.setBounds(40,280,100,20);
        b2.setBounds(200,280,100,20);
        add(b1);
        add(b2);
		
        b1.addActionListener(this);
        b2.addActionListener(this);
        choice.addItemListener(this);  // used to work with selective data
        
        getContentPane().setBackground(Color.WHITE);
       
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);  
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		try 
		{
			DbConn c1 = new DbConn();
//executing sql query to fetch the data selectively			
			ResultSet rs = c1.s.executeQuery("select * from salary where id="+choice.getSelectedItem());
			if (rs.next())
			{
				t1.setText(rs.getString("hra"));  //set text is the fucntion to set the values accordingly
				t2.setText(rs.getString("da"));
				t3.setText(rs.getString("med"));
				t4.setText(rs.getString("pf"));
				t5.setText(rs.getString("basic_salary"));
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
			String hra = t1.getText();
			String id = choice.getSelectedItem();
			String da = t2.getText();
			String med = t3.getText();
			String pf = t4.getText();
			String basic_salary = t5.getText();
			
//executing sql query to update the data 			
			String query = "update salary set hra="+hra+", da="+da+",med="+med+",pf="+pf+",basic_salary="+basic_salary+" where id="+choice.getSelectedItem();
			
			try
			{
				DbConn c1 = new DbConn();
				c1.s.executeUpdate(query);   //error h yha
				JOptionPane.showMessageDialog(null, "Salary Updated Successfully");
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
				c1.s.executeUpdate("delete from salary where id="+choice.getSelectedItem());
				JOptionPane.showMessageDialog(null, "Salary Deleted Successfully");
				this.setVisible(false);
			} 
			catch (Exception error) 
			{
				error.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		new Update_Salary().setVisible(true);

	}


}

 
*/