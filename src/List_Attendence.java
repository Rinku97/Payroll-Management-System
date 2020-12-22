import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class List_Attendence extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable t1;  // JTable is used to create Table
	JButton b1;
	String coloumn[] = {"Emp id", "Date Time", "First Half", "Second Half"};  // one dimensional array
	String row_coloumn[][] = new String[15][4]; // two dimensional array
	int i=0,j=0;
	
	public List_Attendence() {
		
		super("View Employee Attendence");
		
		setSize(800,300);
		setLocation(450, 150);
		
		try
		{
			String query = "select * from attendence";
			DbConn c1 = new DbConn();
			ResultSet rs = c1.s.executeQuery(query);
			while(rs.next())
			{
				row_coloumn[i][j++] = rs.getString("id");
				row_coloumn[i][j++] = rs.getString("date_tm");
				row_coloumn[i][j++] = rs.getString("f_half");
				row_coloumn[i][j++] = rs.getString("s_half");
				i++;  // i++ because we will have to move to the next row
				j=0;  // j = 0 because we have to move to the next rowdata
			}
			t1 = new JTable(row_coloumn, coloumn); // We will have to first pass 2d array intot he table after that 1d.
		}
		catch(Exception error) {}
		
		b1 = new JButton("Print");
		add(b1, "South"); //adding button to the frame to the South
		JScrollPane scroll = new JScrollPane(t1); // JScrollPane is the function to add the scroll bar into the table
		add(scroll);
		
		b1.addActionListener(this);  // addActionListener is used to perform clickable action
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try
		{
			t1.print();
		}
		catch(Exception error) {}
		
	}

	public static void main(String[] args) {
		new List_Attendence().setVisible(true);

	}

}
