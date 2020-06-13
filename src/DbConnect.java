import java.sql.*;
public class DbConnect {
	public static Connection dbConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asp","root","welcome");
		return conn;
	}
}