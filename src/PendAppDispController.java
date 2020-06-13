import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.PendingAppServices;
import java.util.*;
import java.sql.*;
public class PendAppDispController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PendAppDAO padao = new PendAppDAO();
		try {
			List<PendingAppServices> list = padao.getAllPendServices();
			RequestDispatcher rd = request.getRequestDispatcher("pendingAppServices.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}