package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProduct 
{
	// Delete a product from the 'products' table by its ID
    public static void deleteProduct(Connection connection, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();

        // SQL statement to delete a product by its ID
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
        	// Set the product ID as a parameter in the SQL statement
            preparedStatement.setInt(1, productId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) 
            {
            	// Product deletion successful
                System.out.println("Product deleted successfully!");
                System.out.println("--------------------------------");
            } 
            else 
            {
            	// Product deletion failed
                System.out.println("Product deletion failed.");
                System.out.println("--------------------------------");
            }
        }
    }
}
