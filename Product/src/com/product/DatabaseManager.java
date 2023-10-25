package com.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager 
{
	// Database connection details
    private static String url = "jdbc:mysql://localhost:3306/productdb";
    private static String username = "root";
    private static String password = "root";

    // Establish a database connection
    public static Connection connect() throws SQLException 
    {
    	// Connect to the database using the provided URL, username, and password
        return DriverManager.getConnection(url, username, password);
    }

    // Create the 'products' table in the database if it doesn't already exist
    public static void createProductTable(Connection connection) throws SQLException 
    {
    	// SQL statement to create the 'products' table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS products ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "price DOUBLE NOT NULL,"
                + "quantity INT NOT NULL"
                + ")";
        try (java.sql.PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) 
        {
        	// Execute the SQL statement to create the table
            preparedStatement.executeUpdate();
        }
    }
}

