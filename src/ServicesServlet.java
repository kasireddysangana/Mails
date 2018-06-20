import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ServicesServlet")
public class ServicesServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("uid");
		out.print("<center><h2>");
		out.print("<a href=''>Online Payments</a><br>");
		out.print("<a href=''>Online Shopping</a><br>");
		out.print("<a href='MoneyTransferServlet?uid="+userName+"'>Money Transfer</a><br>");
		out.print("<a href=''>Check Your Balance</a><br>");
		out.print("<a href=''>Update User Info</a><br>");
		out.print("<a href=''>X Y Z</a><br>");
		//out.print("<input type=hidden name=uid value="+userName+"/>");
	}
}
