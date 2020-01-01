package DAO;

import java.sql.*;


import java.util.*;

import Bean.regbean;
import DB_conn.regconn;


public class regDao
{
		static PreparedStatement ps ,ps1;
		static int a=0 ,p;
		private regbean r;
		
		//Insert function()
		public int insert(regbean r)
		{
			
			try 
			{
				ps = regconn.display().prepareStatement("insert into Registration(name,address,contact,email,gender,city,language,password) values(?,?,?,?,?,?,?,?);");
				ps.setString(1,r.getName());
				ps.setString(2,r.getAddress());
				ps.setString(3,r.getContact());
				ps.setString(4,r.getEmail());
				ps.setString(5,r.getGender());
				ps.setString(6,r.getCity());
				ps.setString(7,r.getLanguage());
				ps.setString(8,r.getPassword());
				a = ps.executeUpdate();
				
				System.out.println("collecting id from Registration");
				Statement st = regconn.display().createStatement();
				ResultSet rt = st.executeQuery("select id from Registration");
				int i=0;
				while(rt.next())
				{
					i=rt.getInt(1);
				}
				
				ps = regconn.display().prepareStatement("insert into Login(id,email,password) values(?,?,?);");
				ps.setInt(1,i);
				ps.setString(2, r.getEmail());
				ps.setString(3,r.getPassword());
				p = ps.executeUpdate();
				if(p>0)
				{
					System.out.println("insert into login");
				}
				else
				{
					System.out.println("not inserted");
				}
				
				
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return a;
			
			

			
			
		}
		
		//List method for gather all data in table
		public static ArrayList<regbean> show()
		{
	          System.out.println("from table tab");

			ArrayList<regbean> ls = new ArrayList<regbean>();
			
			try 
			{
				System.out.println("select try");
				ps = regconn.display().prepareStatement("select * from Registration where status=1");
				ResultSet rt = ps.executeQuery();
				System.out.println("select executed");
				while(rt.next())
				{
					regbean rb = new regbean();
					rb.setId(rt.getInt("id"));
					rb.setName(rt.getString("name"));
					rb.setAddress(rt.getString("address"));
					rb.setContact(rt.getString("contact"));
					rb.setEmail(rt.getString("email"));
					rb.setGender(rt.getString("gender"));
					rb.setCity(rt.getString("city"));
					rb.setLanguage(rt.getString("language"));
					rb.setPassword(rt.getString("password"));
					ls.add(rb);
					System.out.println("all data select ");

				}
			}
			catch (SQLException e) 
			{
				System.out.println("select catch");
				e.printStackTrace();
			}
			return ls ;
			
		}
		
		
		public static int delete(int id)
		{ 
			int i=0;
			System.out.println("in delete function");
			try 
			{
				ps = regconn.display().prepareStatement("update Registration set status=0 where id=?");
				System.out.println("after update query execution");
				ps.setInt(1,id);
				i=ps.executeUpdate();
				ps1= regconn.display().prepareStatement("update Login set status=0 where id=?");
				ps1.setInt(1,id);
				i=ps1.executeUpdate();
				
				
			} catch (SQLException e)
			{
				System.out.println("in catch()");
			}
			
			return i;
			
		}
		
		public static regbean UpdateById(int id)
		{
			//List<regbean> ls1= new ArrayList<regbean>();
			System.out.println("in update try");
			regbean r=null;
			try {
				ps=regconn.display().prepareStatement("select * from Registration where id=?");
				ps.setInt(1,id);
				ResultSet rt1 = ps.executeQuery();
				System.out.println("select executed");
				
				while(rt1.next())
				{
					 r = new regbean();
					r.setId(rt1.getInt("id"));
					r.setName(rt1.getString("name"));
					r.setAddress(rt1.getString("address"));
					r.setContact(rt1.getString("contact"));
					r.setEmail(rt1.getString("email"));
					r.setGender(rt1.getString("gender"));
					r.setCity(rt1.getString("city"));
					r.setLanguage(rt1.getString("language"));
					r.setPassword(rt1.getString("password"));
					//ls1.add(r);
					System.out.println("all data select ");
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return  r;
			
		}
		public static int update(int id)
		{
			int status=0;
			System.out.println("in update query");
			try
			{
			ps=regconn.display().prepareStatement("update Registration set name=? , address=? , contact=? , email=? , gender=? ,city=? , language=? , password=? where id=?");
			ps.setInt(1, id);	
		//	System.out.println("idddddddd " +id);
			regbean r = new regbean();
				ps.setString(2,r.getName());
				ps.setString(3,r.getAddress());
				ps.setString(4,r.getContact());
				ps.setString(5,r.getEmail());
				ps.setString(6,r.getGender());
				ps.setString(7,r.getCity());
				ps.setString(8,r.getLanguage());
				ps.setString(9,r.getPassword());
				status = ps.executeUpdate();
		//	System.out.println(""+r.getGender());
			}
			catch(Exception e)
			{
				System.out.println("in catch statement");
			}
			return status;
	
		}
		
		public static List<regbean> getSuppByID(int id)
		{
			List<regbean> list=new ArrayList<regbean>();
			Connection con=regconn.display();
			try
			{
				
				PreparedStatement ps=con.prepareStatement("select * from Registration where status=1 and id="+id);
				ResultSet rs=ps.executeQuery(); 
				while(rs.next())
				{
					regbean s=new regbean();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setAddress(rs.getString("address"));
					s.setContact(rs.getString("contact"));
					s.setEmail(rs.getString("email"));
					s.setGender(rs.getString("gender"));
					s.setCity(rs.getString("city"));
					s.setLanguage(rs.getString("language"));
					s.setPassword(rs.getString("password"));
					list.add(s);
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();

			}
			return list;
		}
}
