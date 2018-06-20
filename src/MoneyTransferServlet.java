import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/MoneyTransferServlet")
public class MoneyTransferServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String userName = request.getParameter("uid");
		out.print("<form action=TransactionServlet>");
		out.print("<table width=50% align=center>");
		out.print("<tr>");
		out.print("<td>Destination Bank Name</td>");
		out.print("<td><input type=text name=dbname></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Destination Bank Account</td>");
		out.print("<td><input type=text name=dbacc></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Amount to be Transfered</td>");
		out.print("<td><input type=text name=amount></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><input type=submit value=Transact></td>");
		out.print("<td><input type=reset name=Cancel></td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("<input type=hidden name=uid value="+userName+">");
		out.print("</form>");
	}
}
