package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2;
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/meradb", "root", "root");
		
		// Step 3
		Statement stmt=con.createStatement();
		
		// Step 4
		ResultSet rs=stmt.executeQuery("select * from emp");
		int id, salary;
		String name, desig, dept;
		System.out.println("Employee Details");
		System.out.println("----------------");
		while(rs.next())
		{
			id=rs.getInt(1);
			name=rs.getString(2);
			desig=rs.getString(3);
			dept=rs.getString(4);
			salary=rs.getInt(5);
			
			System.out.println(id+"  "+name+"  "+desig+"  "+dept+"  "+salary);
		}
		con.close();
	}

}
