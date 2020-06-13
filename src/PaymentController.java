import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class PaymentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("billing.html");
		String dat = request.getParameter("dat");
		HttpSession hs = request.getSession(true);
		hs.setAttribute("dat", dat);
		rd.forward(request, response);
	}
}