import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String custid = request.getParameter("custid");
		String pwd = request.getParameter("custpass");
		int flag=0;
		try
		{
			Connection conn = DbConnect.dbConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select mail,pwd,name from acc");
			while(rs.next())
			{
				if(custid.equals("admin") && pwd.equals("admin"))
				{
					HttpSession hs= request.getSession(true);
					flag=1;
					response.sendRedirect("http://localhost:8080/ASP/admindash.html");
					/*st.close();
				conn.close();
				System.exit(0);*/
				}
				if(custid.equals(rs.getString(1)) && pwd.equals(rs.getString(2)))
				{
					HttpSession hs= request.getSession();
					flag=1;
					hs.setAttribute("LOGIN", custid);
					hs.setAttribute("name", rs.getString(3));
					response.sendRedirect("http://localhost:8080/ASP/userdash.html");
				}
			}	
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		if(flag==0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Incorrect Login ID/Password');");
			out.println("location='login.html';");
			out.println("</script>");
		}
	}
}