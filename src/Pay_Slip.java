import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
public class Pay_Slip extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice choice;
	JTextArea text;
	JButton b1, b2;
	
	
	public Pay_Slip() {
		
		setSize(800,700);
		setLocation(400,150);
		choice = new Choice();
		
		try
		{
			DbConn c1 = new DbConn();
			ResultSet rs = c1.s.executeQuery("select * from salary");
			
			while(rs.next())
			{
				choice.add(rs.getString("id"));
			}
		}
		catch(Exception error) {}
		
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Select Id"));
		p1.add(choice);
		add(p1, "North");
		
		text = new JTextArea(30,80);
		JScrollPane jsp = new JScrollPane(text);
		
		Font font  = new Font("arial", Font.BOLD, 20);
		text.setFont(font);
		
		b1 = new JButton("Generate Pay Slip");
		add(b1, "South");
		add(jsp, "Center");
		
		b1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try
		{
			DbConn c1 = new DbConn();
			
			ResultSet rs = c1.s.executeQuery("select * from employee where id="+choice.getSelectedItem());
			rs.next();
			String name = rs.getString("name");
			rs.close();
			
			rs = c1.s.executeQuery("select * from salary where id="+choice.getSelectedItem());
			double gross_salary = 0;
			double net_salary = 0; 
			int month = Calendar.getInstance().get(Calendar.MONTH);
			String current_MonthName = "";
			if (month >= 0 && month <= 11 ) 
			{
				DateFormatSymbols dfs = new DateFormatSymbols();
		        String[] months = dfs.getMonths();
		        String month_name = months[month];
		        current_MonthName = month_name;
		    }			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			text.setText("       PAY SLIP FOR THE MONTH OF "+current_MonthName.toUpperCase()+", "+year+" ");  //this setYext function is used to set the text onto the text are. We can not use setText more than one time because it will override the text. 
			text.append("\n"); // append is used to bypass the override 
			
			if(rs.next())
			{
				text.append("\n           Employee ID " + rs.getString("id"));
				text.append("\n           Employee Name " + name);
				
				text.append("\n ----------------------------------------------------------------------------");
				text.append("\n");
				
				double hra = rs.getDouble("hra");
				text.append("\n            HRA                        : "+hra);
				double da = rs.getDouble("da");
				text.append("\n            DA                          : "+da);
				double med = rs.getDouble("med");
				text.append("\n            MED                       : "+med);
				double pf = rs.getDouble("pf");
				text.append("\n            PF                          : "+pf);
				double basic_sal = rs.getDouble("basic_salary");
				gross_salary = hra+da+pf+med+basic_sal;
				net_salary = gross_salary-pf;
				
				text.append("\n            BASIC SALARY      : "+basic_sal);
				text.append("\n ----------------------------------------------------------------------------");
				text.append("\n            GROSS SALARY    : "+gross_salary);
				text.append("\n            NET SALARY         : "+net_salary);
				text.append("\n            TAX                       : 2.1 % of gross "+(gross_salary*2.1/100));
				text.append("\n");
				text.append("\n");
				text.append("\n");
				text.append("   ( Signature )       ");		
			}
			
			
		}
		catch(Exception error)
		{
			error.printStackTrace();
		}
		
		
		
	}

	public static void main(String[] args) {
		new Pay_Slip().setVisible(true);

	}

}
