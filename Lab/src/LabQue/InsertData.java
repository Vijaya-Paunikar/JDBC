/*
 Q.2 The employees table in the database has the following columns: id, first_name, last_name, and age. Write a Java 
 program using JDBC to insert a new employee record into the table. The employee's first name is "John," last name is
 "Doe" and age is 30.
 */

package LabQue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData 
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        
    	// Step 1: Load the MySQL JDBC driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish a database connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meradb", "root", "root");

        // Step 3: Create a PreparedStatement for inserting data into the EMPLOYEES table
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO EMPLOYEES (first_name, last_name, age) VALUES (?, ?, ?)");

        // Create a Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompt the user for employee information
        System.out.print("Enter Employee's First Name: ");
        String first_name = sc.nextLine();

        System.out.print("Enter Employee's Last Name: ");
        String last_name = sc.nextLine();

        System.out.print("Enter Employee's Age: ");
        int age = sc.nextInt();

        // Set the user-input values for the PreparedStatement
        pstmt.setString(1, first_name);
        pstmt.setString(2, last_name);
        pstmt.setInt(3, age);

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
