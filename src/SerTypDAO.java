import java.sql.*;
import java.util.*;
import model.SerType;;
public class SerTypDAO {
	public List<SerType> getAllVehName() throws SQLException, ClassNotFoundException{
		Connection conn = DbConnect.dbConnection();
		List<SerType> list = new ArrayList<SerType>();
		String sql = "SELECT DISTINCT sername FROM newseradmin";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			SerType req1 = new SerType();
			req1.setSername(rs.getString("sername"));
			list.add(req1);
		}	
		ps.close();
		conn.close();
		return list;
	}
	
	//String sql = "SELECT DISTINCT sername FROM newseradmin where vehtyp=";
	public List<SerType> getAllVehNameCar() throws SQLException, ClassNotFoundException{
		Connection conn = DbConnect.dbConnection();
		List<SerType> list = new ArrayList<SerType>();
		String sql = "SELECT DISTINCT sername FROM newseradmin where vehtyp='Car'";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			SerType req1 = new SerType();
			req1.setSername(rs.getString("sername"));
			list.add(req1);
		}	
		ps.close();
		conn.close();
		return list;
	}
	public List<SerType> getAllVehNameBike() throws SQLException, ClassNotFoundException{
		Connection conn = DbConnect.dbConnection();
		List<SerType> list = new ArrayList<SerType>();
		String sql = "SELECT DISTINCT sername FROM newseradmin where vehtyp='bike'";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			SerType req1 = new SerType();
			req1.setSername(rs.getString("sername"));
			list.add(req1);
		}	
		ps.close();
		conn.close();
		return list;
	}
}
