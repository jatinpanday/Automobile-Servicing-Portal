import java.sql.*;
import java.util.*;
import model.SerReqCust;
public class SerReqCustDAO {
	public List<SerReqCust> getAllVehName() throws SQLException, ClassNotFoundException{
		Connection conn = DbConnect.dbConnection();
		List<SerReqCust> list = new ArrayList<SerReqCust>();
		String sql = "SELECT DISTINCT vehtyp FROM newseradmin";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			SerReqCust req1 = new SerReqCust();
			req1.setVehtyp(rs.getString("vehtyp"));
			list.add(req1);
		}	
		ps.close();
		conn.close();
		return list;
	}
}
