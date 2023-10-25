package LabQue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		// Step 1: Load the MySQL JDBC driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish a database connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab", "root", "root");

        // Step 3: Create a PreparedStatement for inserting data into the EMPLOYEES table
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO Student (Stud_ID, Name, Percentage) VALUES (?, ?, ?)");

        // Create a Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompt the user for employee information
        
        	System.out.print("Enter Your Name: ");
        	String Name = sc.nextLine();
        
        	System.out.print("Enter Student ID: ");
        	int Stud_ID = sc.nextInt();
        

        	System.out.print("Enter Your Percentage: ");
        	float Percent = sc.nextFloat();
        

        // Set the user-input values for the PreparedStatement
        	pstmt.setInt(1, Stud_ID);
        	pstmt.setString(2, Name);
        	pstmt.setFloat(3, Percent);
       

        // Close the Scanner Class
        sc.close();

        // Execute the SQL query to insert data and get the number of affected rows
        int rowsInserted = pstmt.executeUpdate();

        // Step 4: Close the database connection
        con.close();

        // Display the result
        System.out.println(rowsInserted + " record(s) added successfully!!!");
    
	}

}
