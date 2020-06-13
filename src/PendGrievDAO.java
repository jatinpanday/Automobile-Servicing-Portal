import java.sql.*;
import java.util.*;
import model.PendGriev;
public class PendGrievDAO {
	public List<PendGriev> getAllPendGriev() throws SQLException, ClassNotFoundException{
		Connection conn = DbConnect.dbConnection();
		List<PendGriev> list = new ArrayList<PendGriev>();
		String sql = "select *from griev where status='pending'";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			PendGriev pas=new PendGriev();
			pas.setGid(rs.getInt("gid"));
			pas.setSerno(rs.getInt("serno"));
			pas.setProb(rs.getString("prob"));
			pas.setStatus(rs.getString("status"));
			list.add(pas);
		}			
		ps.close();
		conn.close();
		return list;
	}
}
