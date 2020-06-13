import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class GrievenceServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int serid = Integer.parseInt(request.getParameter("serid"));
		String descr = request.getParameter("descr");
		String status = "Pending";
		try{
			Connection conn = DbConnect.dbConnection();
			PreparedStatement pst = conn.prepareStatement("insert into griev(serno,prob,status) values (?,?,?)");
			pst.setInt(1, serid);
			pst.setString(2, descr);
			pst.setString(3, status);
			pst.executeUpdate();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Your problem recorded');");
			out.println("location='userdash.html';");
			out.println("</script>");
			pst.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}