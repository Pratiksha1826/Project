package DB_conn;

import java.sql.Connection;

import java.sql.DriverManager;

public class regconn 
{
	static Connection con;
	public static Connection display()
	{
		try 
		{
			System.out.println("for connection");
			Class.forName("com.mysql.jdbc.Driver");   //class not found error
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Project","root","");
			System.out.println("connection created");
		} catch (Exception e) 
		{
			System.out.println("Exception occure");
		}
		return con;
		
	}


}
