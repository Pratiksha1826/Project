package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Loginbean;
import DAO.logindao;
import DAO.regDao;

/**
 * Servlet implementation class Loginbean
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("login_servlet");
		
		String username = request.getParameter("username");
		System.out.println("Username :" +username);
		
		String password = request.getParameter("password");
		System.out.println("Password :" +password);
		
		logindao d = new logindao();
		if(d.valid_data(username,password))
		{
			System.out.println("for table formate");
			RequestDispatcher rd = request.getRequestDispatcher("formtab.jsp"); 
			rd.forward(request, response);
		}
		else
		{
			//System.out.println("Enter correct email and password!!!!!!");
	           request.setAttribute("errorMessage", "Invalid user or password");
	           response.sendRedirect("login.jsp");
	           //RequestDispatcher rb = request.getRequestDispatcher("login.jsp");
	           //rb.include(request,response);
		}
		
	}

}
