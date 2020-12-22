import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class List_Employee extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable t1;  // JTable is used to create Table
	JButton b1;
	String coloumn[] = {"Emp id", "Name", "Gender", "Address", "State", "City", "Email id", "Phone"};  // one dimensional array
	String row_coloumn[][] = new String[20][8]; // two dimensional array
	int i=0,j=0;
	 
	public List_Employee() {
		
		super("View Employee");

//Making Frame by giving the size and the location
		setSize(1000, 400);
		setLocation(450,200);
		
		try
		{
			String query = "select * from employee";
			DbConn c1 = new DbConn();
			ResultSet rs = c1.s.executeQuery(query);
			while(rs.next())   // next() fucntion moves to coloumn to column
			{
				//initially i and j are 0 ---> i=0, j=0
				row_coloumn[i][j++] = rs.getString("id");  // getString() function used to retrieve the selected item from the table
				row_coloumn[i][j++] = rs.getString("name"); //j++ because we will have to move to the next coloumn everytime
				row_coloumn[i][j++] = rs.getString("gender");
				row_coloumn[i][j++] = rs.getString("address");
				row_coloumn[i][j++] = rs.getString("state");
				row_coloumn[i][j++] = rs.getString("city");
				row_coloumn[i][j++] = rs.getString("email");
				row_coloumn[i][j++] = rs.getString("phone");
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
		new List_Employee().setVisible(true);

	}

	

}
