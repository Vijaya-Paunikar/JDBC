package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo 
{
	
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/meradb", "root", "root");
		
		// Step 3
		Statement stmt=con.createStatement();
		
		// Step 4
		int a=stmt.executeUpdate("insert into emp values(5,'Sakshi','President','Mechanical',334545)");
		System.out.println("Successfully added employee" +a);
		
		// Step 5
		con.close();
	}

}











