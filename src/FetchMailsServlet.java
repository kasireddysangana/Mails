import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wavelabs.entity.User;
import com.wavelabs.dao.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/FetchMailsServlet")
public class FetchMailsServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String userName = request.getParameter("uid");
		//String password = request.getParameter("pwd");
		User u = new User();
		u.setUserName(userName);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<String> mails = new UsersDAO().getMailsOfUser(u);
		out.print("<h3>");
		if(mails!=null)
		{
			for(String m : mails)
			{
				out.print("<a href=''>");
				out.print("<input type=checkbox>"+m);
				out.print("</a><br>");
			}
		}
		out.print("</h3>");
	}

}
