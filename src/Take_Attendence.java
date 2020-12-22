import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Take_Attendence extends JFrame implements ActionListener, ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,EmpName;  // these are labels that are used in this frame
	JButton b1,b2;  // These are the two buttons used in this frame
	Choice choice, firstHalf, secondHalf; //  this is the choice for selection
	JTextField name;
	
	public Take_Attendence() {
		super("Take Attendence");
		
		setLayout(new GridLayout(5,2,50,50));
		choice = new Choice();
		try
		{
			DbConn c1 = new DbConn();
			ResultSet rs = c1.s.executeQuery("select * from employee");
			
			while(rs.next())
			{
				choice.add(rs.getString("id"));
			}
		}
		catch(Exception error) {}
		
		
		add(new JLabel("Selcet Empno"));
		add(choice);
		
		EmpName = new JLabel("Emp Name");
		name = new JTextField(15);
		add(EmpName);
		add(name);
		
		l1 = new JLabel("First Half");
		firstHalf = new Choice();
		firstHalf.add("Present");
		firstHalf.add("Absent");
		firstHalf.add("Leave");
		add(l1);
		add(firstHalf);
		
		l2 = new JLabel("Second Half");
		secondHalf = new Choice();
		secondHalf.add("Present");
		secondHalf.add("Absent");
		secondHalf.add("Leave");
		add(l2);
		add(secondHalf);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }});
		choice.addItemListener(this);
		
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
			ResultSet rs = c1.s.executeQuery("select * from employee where id="+choice.getSelectedItem());
			if (rs.next())
			{
				name.setText(rs.getString("name"));  //set text is the fucntion to set the values accordingly
			}
		}
		catch(Exception error)
		{
			error.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			String first_half = firstHalf.getSelectedItem();
			String second_half = secondHalf.getSelectedItem();
			String date = new java.util.Date().toString();
			String id = choice.getSelectedItem();
			String query = "insert into attendence values('"+id+"', '"+date+"', '"+first_half+"', '"+second_half+"')";
			
			try
			{
				DbConn c1 = new DbConn();
				c1.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Attendence Confirmed Successfully");
				this.setVisible(false);
			}
			catch(Exception error)
			{
				error.printStackTrace();
			}
	}

	public static void main(String[] args) {

		new Take_Attendence().setVisible(true);
	}

}
