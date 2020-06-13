import java.sql.*;
import java.util.*;
import model.Review;
public class ReviewDAO {
	public List<Review> getAllReviews() throws SQLException, ClassNotFoundException{
		List<Review> list = new ArrayList<Review>();
		Connection conn = DbConnect.dbConnection();
		String sql = "select *from feedback";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Review review = new Review();
			review.setName(rs.getString(1));
			review.setRating(rs.getInt(2));
			review.setReview(rs.getString(3));
			list.add(review);
		}
		ps.close();
		conn.close();
		return list;
			
	}	
}