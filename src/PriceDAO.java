import java.sql.*;
import java.util.*;
import model.Price;

public class PriceDAO {
	public  List<Price> getAllPrice() throws SQLException, ClassNotFoundException{
		Connection conn = DbConnect.dbConnection();
		List<Price> list = new ArrayList<Price>();
		String sql = "SELECT * FROM NEWSERADMIN";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Price price=new Price();
			price.setSid(rs.getString("sid"));
			price.setVehtyp(rs.getString("vehtyp"));
			price.setSername(rs.getString("sername"));
			price.setSerprice(rs.getString("serprice"));
			price.setDescr(rs.getString("descr"));
			list.add(price);
		}			
		ps.close();
		conn.close();
		return list;
		
	}
}