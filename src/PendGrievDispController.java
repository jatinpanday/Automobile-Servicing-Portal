import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.PendGriev;
public class PendGrievDispController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PendGrievDAO pgdao = new PendGrievDAO();
		try {
			List<PendGriev> list = pgdao.getAllPendGriev();
			RequestDispatcher rd = request.getRequestDispatcher("pendingGriev.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}