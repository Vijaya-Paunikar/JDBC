package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class updatequery 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/meradb", "root", "root");
				
		// Step 3
		PreparedStatement psmt=con.prepareStatement("update emp set department=?, salary=? where id=?");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your id:");
		String id;
		
	}

}
/*
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/meradb", "root", "root");
		
		// Step 3
		PreparedStatement pstmt=con.prepareStatement("update emp set department=?, salary=? where id=?");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter employee id:");
		String id=sc.next();
		
		System.out.println("Enter employee Name:");
		String name=sc.next();
		
		System.out.println("Enter employee designation:");
		String desig=sc.next();
		
		System.out.println("Enter employee department:");
		String dept=sc.next();
		
		System.out.println("Enter employee salary:");
		int sal=sc.nextInt();
		
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, desig);
		pstmt.setString(4, dept);
		pstmt.setInt(5, sal);
		
		int r=pstmt.executeUpdate();
		con.close();
		System.out.println(r+" record added successfully!!!");
 */

