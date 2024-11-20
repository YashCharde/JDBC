package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentJdbcSc {

	public static void Create() throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
		PreparedStatement ps = c.prepareStatement("INSERT INTO student (stud_id , name ,  age ) VALUES (?, ?, ?)");

		System.out.print("Enter student id : ");
		int stud_id = sc.nextInt();
		ps.setInt(1, stud_id);

		System.out.print("enter Student name : ");
		String name = sc.next();
		ps.setString(2, name);

		System.out.print("Enter Student age : ");
		int age = sc.nextInt();
		ps.setInt(3, age);

		ps.executeUpdate();
		
		System.out.println("data inserted ......");
		Read();

	}

	public static void Read() throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
        PreparedStatement ps = c.prepareStatement("SELECT  name, age FROM Student WHERE stud_id = ?");
        ps.setInt(1, 1);
        
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
        	System.out.println("student detail : ");
        	System.out.println("name : "+ rs.getString(1));
        	System.out.println("age : "+ rs.getInt(2));
        }else {
        	System.out.println("stud_id not found");
        }
        
	}

	public static void Update() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
        PreparedStatement ps = c.prepareStatement("UPDATE student SET name = ?,age = ?  WHERE stud_id = ?");
        
        Read();
        
        System.out.println();
        System.out.println("Update the student data....!");
        System.out.println();
        
        System.out.print("Enter name of student : ");
        String name = sc.next();
        ps.setString(1, name);
        
        System.out.print("Enter age of student :");
        int age = sc.nextInt();
        ps.setInt(2, age);
        
        System.out.print("Enter stud_id  of student  :");
        int stud_id = sc.nextInt();
		ps.setInt(3, stud_id);
		
		ps.executeUpdate();
		System.out.println("data updated ......");
		
		System.out.println();
		
		Read();

	}

	public static void Delete() throws Exception{

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc", "root", "yash");
        PreparedStatement ps = c.prepareStatement("DELETE FROM student WHERE stud_id = ?");
        
        System.out.println("Enter student id : ");
        int stud_id = sc.nextInt();
        ps.setInt(1, stud_id );
        
        ps.executeUpdate();
        System.out.println("data delated ......");

	}

}
