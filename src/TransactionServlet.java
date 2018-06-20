import javax.servlet.http.HttpServlet;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import com.wavelabs.dao.UsersDAO;
import javax.servlet.http.Cookie;
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet implements SingleThreadModel{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// String userName = request.getParameter("uid"); // Commented for Cookie
		double amount = Double.parseDouble(request.getParameter("amount"));
		/* Commented for HttpSession Object */
		/* Code changed for Cookie - Start*/
		/*String userName ="";
		Cookie[] cs = request.getCookies();
		for(Cookie c : cs)
			if(c.getName().equals("userName"))
				userName = c.getValue();*/
		/* Code changed for Cookie - End*/
		
		/* Code added for HttpSession Object - Start */
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		session.invalidate(); // Session will be killed if we don't need session further
		/* Code added for HttpSession Object - End */
		System.out.println("userName is : "+userName);
		UsersDAO udao = new UsersDAO();
		out.print("<html><body>");
		out.print("<center><h1>");
		if(udao.transferMoney(userName,amount))
				out.print("Your Transaction is successfully Completed!!!");
		else 
			out.print("Your Transaction is Failled");
		out.print("<h1></center>");
		out.print("</body></html>");
	}
}
