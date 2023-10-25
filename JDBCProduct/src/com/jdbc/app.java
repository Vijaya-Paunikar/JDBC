/*
 Q.1)WAP to perform CRUD operation on Product database based on choice given by user using switch case using JDBC.
*/

package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class app 
{

    public static void main(String[] args) 
    {
        String url = "jdbc:mysql://localhost:3306/lab";
        String username = "root";
        String password = "root";

        try 
        {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in)) 
            {
            	// Create the products table if it doesn't exist
                createProductTable(connection);
                
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
                            createProduct(connection, scanner);
                            break;
                        case 2:
                            readProduct(connection, scanner);
                            break;
                        case 3:
                            updateProduct(connection, scanner);
                            break;
                        case 4:
                            deleteProduct(connection, scanner);
                            break;
                        case 5:
                        	getAllProducts(connection);
                        	break;
                        case 6:
                            System.out.println("Application Stopped...");
                            System.out.println("--------------------------------");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            System.out.println("--------------------------------");
                    }
                }
            }
        } 
        catch (SQLException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
    
    // Create the products table if it doesn't exist
    private static void createProductTable(Connection connection) throws SQLException 
    {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS products ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "price DOUBLE NOT NULL,"
                + "quantity INT NOT NULL"
                + ")";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) 
        {
            preparedStatement.executeUpdate();
        }
    }

    // Method to create/add a new product
    private static void createProduct(Connection connection, Scanner scanner) throws SQLException 
    {
    	System.out.print("Enter product name: ");
    	String name = scanner.next();
    	System.out.print("Enter product price: ");
    	double price = scanner.nextDouble();
    	System.out.print("Enter product quantity: ");
    	int quantity = scanner.nextInt();

    	String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
    	try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
    	{
    			preparedStatement.setString(1, name);
    			preparedStatement.setDouble(2, price);
    			preparedStatement.setInt(3, quantity);
    			int rowsInserted = preparedStatement.executeUpdate();
    			if (rowsInserted > 0) 
    			{
    				System.out.println("Product created successfully!");
    				System.out.println("--------------------------------");
    			} 
    			else 
    			{
    				System.out.println("Product creation failed.");
    				System.out.println("--------------------------------");
    			}
    		}
    	}
    
 // Method to read a product by ID
    private static void readProduct(Connection connection, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();

        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) 
            {
                System.out.println("Product ID: " + resultSet.getInt("id"));
                System.out.println("Product Name: " + resultSet.getString("name"));
                System.out.println("Product Price: " + resultSet.getDouble("price"));
                System.out.println("Product Quantity: " + resultSet.getInt("quantity"));
                System.out.println("--------------------------------");
            } 
            else 
            {
                System.out.println("Product not found.");
                System.out.println("--------------------------------");
            }
        }
    }

    // Method to update a product
    private static void updateProduct(Connection connection, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter new product name: ");
        String name = scanner.next();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new product quantity: ");
        int quantity = scanner.nextInt();

        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4, productId);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) 
            {
                System.out.println("Product updated successfully!");
                System.out.println("--------------------------------");
            } 
            else 
            {
                System.out.println("Product update failed.");
                System.out.println("--------------------------------");
            }
        }
    }

    // Method to delete a product by ID
    private static void deleteProduct(Connection connection, Scanner scanner) throws SQLException 
    {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();

        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
            preparedStatement.setInt(1, productId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) 
            {
                System.out.println("Product deleted successfully!");
                System.out.println("--------------------------------");
            } 
            else 
            {
                System.out.println("Product deletion failed.");
                System.out.println("--------------------------------");
            }
        }
    }
    
    // Method to get all products
    private static void getAllProducts(Connection connection) throws SQLException 
    {
        String sql = "SELECT * FROM products";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) 
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) 
            {
                System.out.println("Product ID: " + resultSet.getInt("id"));
                System.out.println("Product Name: " + resultSet.getString("name"));
                System.out.println("Product Price: " + resultSet.getDouble("price"));
                System.out.println("Product Quantity: " + resultSet.getInt("quantity"));
                System.out.println("--------------------------------");
            }
        }
    }
}
