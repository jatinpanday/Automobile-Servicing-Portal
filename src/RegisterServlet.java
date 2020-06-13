import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn=null;
		try {
			conn = DbConnect.dbConnection();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement st= null;
		try {
			st = conn.prepareStatement("insert into acc(pwd,cpwd,name,addr,mail,mno) values(?,?,?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name =  request.getParameter("name");
		String pwd =  request.getParameter("pwd");
		String cpwd =  request.getParameter("cpwd");
		String addr =  request.getParameter("addr");
		String mail =  request.getParameter("mail");
		
		String[] s_mail = mail.split("@");
		if(pwd.equals(cpwd) && mail.contains("@") && s_mail[1].contains(".")) {
			try {
				long mno= Long.parseLong(request.getParameter("mno"));
				response.setContentType("text/html");
				st.setString(1,pwd);
				st.setString(2, cpwd);
				st.setString(3, name);
				st.setString(4, addr);
				st.setString(5, mail);
				st.setLong(6, mno);
				st.execute();
				st.close();
				//out.println("<b><center><h1>Record Registered Successfully</br>Redirecting to the login page</h1></center></b>");
				response.sendRedirect("http://localhost:8080/ASP/login.html");
			}
			catch(Exception e) {
				out.print(e);
			}
		}			
		else {
			out.println("<b><center><h1>Check Instructions Carefully</h1></center></b>");
			out.println("<b><center>1. Password must be same as confirm password</br>2. E-mail id must be in the format as abc@abc.com</center></b>");
			
		}
	}	
}