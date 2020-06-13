import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class GrievChangeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String stat = request.getParameter("stat");
		try {
			Connection conn = DbConnect.dbConnection();
			PreparedStatement pst = conn.prepareStatement("update griev set status='resolved' where status='pending'");
			pst.execute();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Problems Resolved');");
			out.println("location='admindash.html';");
			out.println("</script>");
			pst.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}