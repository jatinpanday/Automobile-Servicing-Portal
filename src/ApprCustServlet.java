import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class ApprCustServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int serid = Integer.parseInt(request.getParameter("serid"));
		try
		{
			Connection conn = DbConnect.dbConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select stat from serreqcust where serid="+serid);
			while(rs.next()) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+rs.getString(1)+"');");
				out.println("location='userdash.html';");
				out.println("</script>");
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
}