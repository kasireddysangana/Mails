import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.wavelabs.entity.User;
import com.wavelabs.entity.UserDetails;
import com.wavelabs.dao.UsersDAO;
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends GenericServlet{
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException
	{
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		Long phone = Long.parseLong(request.getParameter("phone"));
		String address = request.getParameter("address");
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		User user = new User(userName,password);
		UserDetails ud = new UserDetails(user,firstName,lastName,phone,address);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.print("<center><h1>");
		if(new UsersDAO().createUser(ud))
			out.print("User Registered Successfully");
		else
			out.print("Opps... Registration Failed");
		
		out.print("</h1></center>");
		out.print("</body></html>");
	}
	

}
