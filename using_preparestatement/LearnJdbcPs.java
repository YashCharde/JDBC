package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LearnJdbcPs {

	public static void Create() throws Exception {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc","root","yash");
        PreparedStatement ps = c.prepareStatement("INSERT INTO Products (product_id, product_name, price, quantity) VALUES (?, ?, ?, ?)");
        ps.setInt(1, 100);                
        ps.setString(2, "laptop");        
        ps.setDouble(3, 80000.00);        
        ps.setInt(4, 1);     
        ps.executeUpdate();
        System.out.println("Data Inserted ....");
        Read();
       
	}

	public static void Read() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		PreparedStatement ps = c.prepareStatement("SELECT  product_name, price, quantity FROM Products WHERE product_id = ? ");
		ps.setInt(1, 100);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
             System.out.println("Product Name: " + rs.getString(1));
             System.out.println("Price: " + rs.getDouble(2));
             System.out.println("Quantity: " + rs.getInt(3));
		}else {
            System.out.println("No product_id found ");
        }
		
	}

	public static  void Update() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		PreparedStatement ps = c.prepareStatement("UPDATE Products SET price = ?, quantity = ? WHERE product_id = ?");
		ps.setDouble(1, 85000.00);
		ps.setInt(2, 2);
		ps.setInt(3, 100);
		ps.executeUpdate();
		System.out.println("data updated ....");
		Read();

	}

	public static void Delete() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		PreparedStatement ps = c.prepareStatement("DELETE FROM Products WHERE product_id = ?");
		ps.setInt(1, 100);
		ps.executeUpdate();
		System.out.println("Product deleted successfully...");
		Read();
		

	}

	
		
	}


