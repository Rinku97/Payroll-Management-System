import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;
	
	public login() {
		super("Login Page");
		
		setLayout(new BorderLayout());
		t2 = new JPasswordField(10);
		t1 = new JTextField(10);
		JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));
		
		b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
		b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
		b1.addActionListener(this); 
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }});
// Now adding these Label, TextFields and Buttons on to the frame
		JPanel p2,p4;   // This is the lightweight Container for frame
		p2 = new JPanel();
		p4 = new JPanel();
		add(l, BorderLayout.WEST);  // This sets the image on the West side in the frame
		
		p2.add(new JLabel("User Name "));
		p2.add(t1);
		p2.add(new JLabel("Password   "));
		p2.add(t2);
		add(p2, BorderLayout.CENTER);
		
		p4.add(b1);
		p4.add(b2);
		add(p4, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(350, 250);
		
		Toolkit toolkit = getToolkit();
		Dimension Size = toolkit.getScreenSize();
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		try
		{
			DbConn c1 = new DbConn();
			String user = t1.getText();
			char[] pass = t2.getPassword();
			String pasw = new String(pass);
			System.out.println(pasw);
// executing Sql Query to retreive the data			
			String query = "select * from login where username='"+user+"' and password='"+pasw+"'";
			
			ResultSet rs = c1.s.executeQuery(query); // this line execute the query and store the results in rs object
			if(rs.next())
			{
				new project().setVisible(true);
				setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Credential, Login Failed!"); //JOptionpane is used for the dialogbox/popup 
			}
		}
		
		catch(Exception error)
		{
			error.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		new login();
	}

}
