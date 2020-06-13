import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class CreateNewServServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String vehtyp = request.getParameter("vehtyp");
		String sername = request.getParameter("sername");
		int serprice = Integer.parseInt(request.getParameter("serprice"));
		String descr = request.getParameter("descr");
		try {
			Connection conn =  DbConnect.dbConnection();
			PreparedStatement ps = conn.prepareStatement("insert into newseradmin(vehtyp, sername, serprice, descr) values(?,?,?,?)");
			ps.setString(1, vehtyp);
			ps.setString(2, sername);
			ps.setInt(3, serprice);
			ps.setString(4, descr);
			ps.execute();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Values Inserted');");
			out.println("location='admindash.html';");
			out.println("</script>");
			ps.close();
			conn.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}
}