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
 * Servlet implementation class regaction
 */
@WebServlet("/regaction")
public class regaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regaction() {
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
		
		//Take data from jsp page
		System.out.println("in servlet:");
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
		
		//Set data as a private in bean folder
		
		regbean rb = new regbean();
		System.out.println("in bean class");
		rb.setName(name);
		rb.setAddress(address);
		rb.setContact(contact);
		rb.setEmail(email);
		rb.setGender(gender);
		rb.setCity(city);
		rb.setLanguage(language);
		rb.setPassword(password);

		regDao rd = new regDao();
		System.out.println("in regDao:");
		int status = rd.insert(rb);
		System.out.println("Insert metod: "+status);
		
	}

}
