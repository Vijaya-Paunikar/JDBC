package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProduct 
{
	// Update a product's details in the 'products' table.
    public static void updateProduct(Connection connection, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter new product name: ");
        String name = scanner.next();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new product quantity: ");
        int quantity = scanner.nextInt();

        // SQL statement to update a product's details
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
        	// Set parameters for the SQL statement
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4, productId);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) 
            {
            	// Product update successful
                System.out.println("Product updated successfully!");
                System.out.println("--------------------------------");
            } 
            else 
            {
            	// Product update failed
                System.out.println("Product update failed.");
                System.out.println("--------------------------------");
            }
        }
    }
}
