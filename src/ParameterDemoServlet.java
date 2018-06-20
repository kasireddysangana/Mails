import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.*;
@WebServlet(value="/PDS",loadOnStartup=0,initParams=@WebInitParam(name="wish",value="Good Morning"))
public class ParameterDemoServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		//String demoParam = config.getInitParameter("demoParam");
		String demoParam = config.getInitParameter("wish");
		String commonParam1 = context.getInitParameter("commonParam1");
		String commonParam2 = context.getInitParameter("commonParam2");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Parameter Name :- wish </h1>");
		out.print("<h1>Parameter Value :- "+demoParam+"</h1>");
		out.print("<h1>Parameter Name :- commonParam1 </h1>");
		out.print("<h1>Parameter Value :- "+commonParam1+"</h1>");
		out.print("<h1>Parameter Name :- commonParam2 </h1>");
		out.print("<h1>Parameter Value :- "+commonParam2+"</h1>");
		
	}
}
