import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.SerType;

public class SerTypeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SerTypDAO stdao = new SerTypDAO();
		try {
				String type = request.getParameter("vehtyp");
				List<SerType> list = null;
				if (type.equals("bike")) {
					list = stdao.getAllVehNameBike();
				} else {
					list = stdao.getAllVehNameCar();
				}
				HttpSession hs = request.getSession(true);
				hs.setAttribute("vehtyp", request.getParameter("vehtyp"));
				RequestDispatcher rd = request.getRequestDispatcher("SerTyp.jsp");
				request.setAttribute("list", list);
				rd.forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}