import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DbConn {
	
	public Connection c;
	public Statement s;
	
	public DbConn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///payrollsystem","root","");
            s = c.createStatement();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
