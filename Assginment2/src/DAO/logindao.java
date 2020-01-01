package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Loginbean;
import Bean.regbean;
import DB_conn.regconn;

public class logindao 
{
	 boolean status=false;

	public boolean valid_data(String num ,String pass)
	{
		try 
		{
			System.out.println("in try block");
			PreparedStatement ps = regconn.display().prepareStatement("select email , password from Login");
			ResultSet rs = ps.executeQuery();;
			String username=null,password = null;

			System.out.println("after query execute");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				username = rs.getString(1);
				
				System.out.println(rs.getString(2));
				password =rs.getString(2);
				if(username.equals(num) && password.equals(pass))
				{
					status = true;
					break;
				}
			}
			System.out.println("if not equal");
			if(status==false)
			{
				status=false;
			}
			
			

		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return status;
		
		
		
		
		
	}

	

}
