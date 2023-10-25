package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class lab1 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		// Step 1: Load the JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: Establish a database connection
		Connection con = DriverManager.getConnection("jdbc:/mysql://localhost:3306/meradb", "root", "root");
		
		// Step 3: Create a Statement
		Statement stmt=con.createStatement();
		
		// Step 4: Execute SQL query to create the table
        String createTableSQL = "CREATE TABLE EMPLOYEES (id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(50), last_name VARCHAR(50), age INT)";
        stmt.executeUpdate(createTableSQL);
		System.out.println("Employees table created successfully.");
	
		// Step 5: Close the statement and connection
		con.close();
	}

}

