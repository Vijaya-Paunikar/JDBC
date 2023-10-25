package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadProduct 
{	
	// Read details of a product by its ID
    public static void readProduct(Connection connection, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();

        // SQL statement to select a product by its ID
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
        	// Set the product ID as a parameter in the SQL statement
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) 
            {
            	// Print product details
                System.out.println("Product ID: " + resultSet.getInt("id"));
                System.out.println("Product Name: " + resultSet.getString("name"));
                System.out.println("Product Price: " + resultSet.getDouble("price"));
                System.out.println("Product Quantity: " + resultSet.getInt("quantity"));
                System.out.println("--------------------------------");
            } 
            else 
            {
            	// Product not found
                System.out.println("Product not found.");
                System.out.println("--------------------------------");
            }
        }
    }

    // Get details of all products
    public static void getAllProducts(Connection connection) throws SQLException 
    {
    	// SQL statement to select all products
        String sql = "SELECT * FROM products";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) 
            {
            	// Print details of each product
                System.out.println("Product ID: " + resultSet.getInt("id"));
                System.out.println("Product Name: " + resultSet.getString("name"));
                System.out.println("Product Price: " + resultSet.getDouble("price"));
                System.out.println("Product Quantity: " + resultSet.getInt("quantity"));
                System.out.println("--------------------------------");
            }
        }
    }
}
