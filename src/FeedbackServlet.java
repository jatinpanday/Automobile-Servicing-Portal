import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FeedbackServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		HttpSession httpSession=request.getSession(false);
		String name=(String)httpSession.getAttribute("name");
		try{
			Connection conn = DbConnect.dbConnection();
			PreparedStatement pst = conn.prepareStatement("insert into feedback(name,rating,rev) values (?,?,?)");
			pst.setString(1, name);
			pst.setInt(2, Integer.parseInt(request.getParameter("rating")));
			pst.setString(3, request.getParameter("review"));
			pst.executeUpdate();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Feedback Recorded');");
			out.println("location='userdash.html';");
			out.println("</script>");
			 
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}