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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String id1 = request.getParameter("id");
		int id=Integer.parseInt(id1);
		System.out.println("Id :"+id);
		
		String name = request.getParameter("name");
		System.out.println("Name :"+name);
		
		String address = request.getParameter("address");
		System.out.println("Address :"+address);

		String contact = request.getParameter("contact");
		System.out.println("Contact :"+contact);

		String email = request.getParameter("email");
		System.out.println("Email :"+email);

		String gender = request.getParameter("gender");
		System.out.println("Gender :"+gender);

		String city = request.getParameter("city");
		System.out.println("City :"+city);

		String lan[] = request.getParameterValues("language");
		String language = Arrays.toString(lan);
		System.out.println("Language :"+language);

		String password = request.getParameter("pwd");
		System.out.println("Password :"+password);
		
		
		regbean rb = new regbean();
		System.out.println("in bean class");
		//rb.getId(id);
		rb.setName(name);
		rb.setAddress(address);
		rb.setContact(contact);
		rb.setEmail(email);
		rb.setGender(gender);
		rb.setCity(city);
		rb.setLanguage(language);
		rb.setPassword(password);
		
		int s=regDao.update(id);
		System.out.println("satus:"+s);
        response.sendRedirect("formtab.jsp");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
