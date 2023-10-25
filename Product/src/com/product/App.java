/*
 Q.1)WAP to perform CRUD operation on Product database based on choice given by user using switch case using JDBC.
*/

package com.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    {
        try 
        {
        	// Establish a connection to the database
            Connection connection = DatabaseManager.connect();
            Scanner scanner = new Scanner(System.in);

            // Create the products table if it doesn't exist
            DatabaseManager.createProductTable(connection);

            while (true) 
            {
                System.out.println("****** Welcome to Product Management System *******");
                System.out.println("Choose an operation:");
                System.out.println("1. Create Product");
                System.out.println("2. Read Product");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Get All Products");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) 
                {
                    case 1:
                    	// Create a new product
                        CreateProduct.createProduct(connection, scanner);
                        break;
                    case 2:
                    	// Read details of a product
                        ReadProduct.readProduct(connection, scanner);
                        break;
                    case 3:
                    	// Update product information
                        UpdateProduct.updateProduct(connection, scanner);
                        break;
                    case 4:
                    	// Delete a product
                        DeleteProduct.deleteProduct(connection, scanner);
                        break;
                    case 5:
                    	// Get details of all products
                        ReadProduct.getAllProducts(connection);
                        break;
                    case 6:
                    	// Exit the application
                        System.out.println("Application Stopped...");
                        System.out.println("--------------------------------");
                        return;
                    default:
                    	// Invalid choice entered
                        System.out.println("Invalid choice. Please try again.");
                        System.out.println("--------------------------------");
                }
            }
        } 
        catch (SQLException e) 
        {
        	// Handle any SQL-related exceptions
            e.printStackTrace();
        }
    }
}
