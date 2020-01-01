package Action;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.regbean;
import DAO.regDao;

/**
 * Servlet implementation class Delete_servlet
 */
@WebServlet("/Delete_servlet")
public class Delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Delete_servlet");
		String id = request.getParameter("id");
		int i = Integer.parseInt(id.toString());
	
		regbean r = new regbean();
		//regDao rd = new regDao();
		//int id=Integer.parseInt(request.getParameter("id").toString());

		//int id =r.getId();
		System.out.println("id"+id);
		int status = regDao.delete(i);
		System.out.println("Status:"+status);
		System.out.println("After the delete()");
		if(status>0)
		{
		System.out.println("deleted successfully");
		response.sendRedirect("formtab.jsp");

		}
		else
		{
			System.out.println("Data not deleted");
			//response.sendRedirect("formtab.jsp");
		}
		}

}
