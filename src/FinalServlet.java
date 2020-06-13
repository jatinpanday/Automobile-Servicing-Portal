import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FinalServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int flag=0;
		long cardno=Long.parseLong(request.getParameter("cardnumber"));
		int cvv=Integer.parseInt(request.getParameter("cvv"));
		try
		{
			Connection conn = DbConnect.dbConnection();
			PreparedStatement ps = conn.prepareStatement("select * from card");
			ResultSet rs = ps.executeQuery();
			int serprice=0,serid=0;
			while(rs.next())
			{
				if(cardno == rs.getLong(1) && cvv == rs.getInt(2))
				{
					HttpSession hs = request.getSession(true);
					String name = (String) hs.getAttribute("name");
					String stat = "pending";
					String vehtyp = (String)hs.getAttribute("vehtyp");
					String sertyp = (String)hs.getAttribute("sertyp");
					String dat = (String)hs.getAttribute("dat");
					PreparedStatement ps1 = conn.prepareStatement("select serprice from newseradmin where vehtyp=? and sername=?");
					ps1.setString(1, vehtyp);
					ps1.setString(2, sertyp);
					ResultSet rst = ps1.executeQuery();
					while(rst.next()) {
						serprice = rst.getInt(1);
						System.out.println(serprice);
					}
					PreparedStatement ps2 = conn.prepareStatement("insert into serreqcust(reqby,stat,vehtyp,sertyp,bdate,serprice) values(?,?,?,?,?,?)");
					ps2.setString(1, name);
					ps2.setString(2, stat);
					ps2.setString(3, vehtyp);
					ps2.setString(4, sertyp);
					ps2.setString(5, dat);
					ps2.setInt(6,serprice);
					ps2.execute();
					PreparedStatement ps3 = conn.prepareStatement("select serid from serreqcust order by serid desc limit 0, 1");
					rst = ps3.executeQuery();
					while(rst.next()) {
						serid = rst.getInt(1);
					}
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Paid Successfully! Your service id is : " +serid+"');");
					out.println("location='userdash.html';");
					out.println("</script>");
					flag=1;
					/*st.close();
				conn.close();
				System.exit(0);*/
				}
			}
			if(flag==0){
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Incorrect Data!');");
					out.println("location='billing.html';");
					out.println("</script>");				
			}
				
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}