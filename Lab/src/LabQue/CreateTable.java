/*
 Q.1 You need to create a table named employees in the database to store employee information.
     Write a Java program using JDBC to create the employees table with the following columns:

     id of type INT, which is the primary key and auto-incremented.
     first_name of type VARCHAR(50) to store the employee's first name.
     last_name of type VARCHAR(50) to store the employee's last name.
     age of type INT to store the employee's age.
 */

package LabQue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTable
{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		// Step 1: Load the MySQL JDBC driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: Establish a database connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/meradb", "root", "root");
		
		// Step 3: Create a Statement object for executing SQL queries
		Statement stmt=con.createStatement();
		
		// Step 4: Execute an SQL query to create a table
		stmt.executeUpdate("CREATE TABLE EMPLOYEES(id INT AUTO_INCREMENT PRIMARY KEY,first_name VARCHAR(50),last_name VARCHAR(50),age INT)");
		System.out.println("Employee Table Created Successfully!!!");
		
		// Step 5: Close the database connection
		con.close();
	}

}
