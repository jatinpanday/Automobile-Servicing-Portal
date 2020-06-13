import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class SignoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession(true);
		hs.invalidate();
		response.sendRedirect("http://localhost:8080/ASP/homepage.html");
	}
}