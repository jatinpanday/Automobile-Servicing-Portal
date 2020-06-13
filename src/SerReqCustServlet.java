import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.SerReqCust;
public class SerReqCustServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SerReqCustDAO srcdao1 = new SerReqCustDAO();
		try {
			List<SerReqCust> list = srcdao1.getAllVehName();
			RequestDispatcher rd = request.getRequestDispatcher("SerReqCust.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}