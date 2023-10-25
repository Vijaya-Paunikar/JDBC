package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateProduct 
{
	// Create a new product in the 'products' table
    public static void createProduct(Connection connection, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

     // SQL statement to insert a new product into the table
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
        	// Set parameters for the SQL statement
        	preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, quantity);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) 
            {
            	// Product creation successful
                System.out.println("Product created successfully!");
                System.out.println("--------------------------------");
            }
            else 
            {
            	// Product creation failed
                System.out.println("Product creation failed.");
                System.out.println("--------------------------------");
            }
        }
    }
}
