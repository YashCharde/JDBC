package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LearnJdbc {

	public static void Create() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		Statement s = c.createStatement();
		s.executeUpdate("INSERT INTO Employee VALUES(1, 'Shivam', 50000)");
		System.out.println("Data Inserted ....");
		Read();

	}

	public static void Read() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT name, salary FROM Employee WHERE emp_id = 1");
	    
		if (rs.next()) {
            String name = rs.getString("name");
            int salary = rs.getInt("salary");

            System.out.println("Employee Data: ");
            System.out.println("Name: " + name);
            System.out.println("Salary: " + salary);
        } else {
            System.out.println("No employee found with emp_id = 1");
        }
		
	}

	public static void Update() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		Statement s = c.createStatement();
		s.executeUpdate("UPDATE Employee SET name = 'shiv' WHERE emp_id = 1 ");
		System.out.println("data updated ....");
		Read();
	}

	public static void Delete() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		Statement s = c.createStatement();
		s.execute("DELETE FROM Employee WHERE emp_id = 1");
		System.out.println("Data delated .....");
		Read();
	}

}
