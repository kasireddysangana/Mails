import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wavelabs.entity.User;
import com.wavelabs.dao.UsersDAO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@WebServlet("/AuthenticateUserServlet")

public class AuthenticateUserServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String userName = request.getParameter("uid");
		String password = request.getParameter("pwd");
		User u = new User(userName, password);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		out.print("<htm> <body>");
//		out.print("<h2>");
		
		// Commented For HttpSession Object
//		Cookie c = new Cookie("userName",userName);
//		response.addCookie(c);
		
		// Added for HttpSession Object - Start
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		// Added for HttpSession Object - End
		
		RequestDispatcher rd = null;
		if(new UsersDAO().checkUser(u))
		{
			out.print("<center><h1>Welcome to Wavelabs</h1></center");
			//rd = request.getRequestDispatcher("FetchMailsServlet");
			//rd = request.getRequestDispatcher("ServicesServlet"); // Commented for Cookies
			rd = request.getRequestDispatcher("services.html"); // This can be a static if we are passing cookie
			rd.forward(request, response);
		}
		else
		{
			out.println("<center><h1>Invalid username or password</h1></center>");
			out.print("<hr width=100% size=3 color=red>");
			rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
	}
}
