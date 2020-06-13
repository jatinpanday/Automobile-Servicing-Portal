import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FinalCustServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("bookingdate.html");
		String sername = request.getParameter("servicename");
		HttpSession hs = request.getSession(true);
		hs.setAttribute("sertyp", sername);
		rd.forward(request, response);
	}
}