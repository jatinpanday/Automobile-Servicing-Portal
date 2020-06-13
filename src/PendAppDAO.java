import java.sql.*;
import java.util.*;
import model.PendingAppServices;
public class PendAppDAO {
	public List<PendingAppServices> getAllPendServices() throws SQLException, ClassNotFoundException{
		Connection conn = DbConnect.dbConnection();
		List<PendingAppServices> list = new ArrayList<PendingAppServices>();
		String sql = "select serid, reqby, stat from serreqcust where stat='pending'";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			PendingAppServices pas=new PendingAppServices();
			pas.setSno(rs.getInt("serid"));
			pas.setReqby(rs.getString("reqby"));
			pas.setStat(rs.getString("stat"));
			list.add(pas);
		}			
		ps.close();
		conn.close();
		return list;
	}
}
