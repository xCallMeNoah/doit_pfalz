import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDriverManager {

	public static Connection getJDBCConnection(AppConfig config) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		/**
		 * Erstellung mittels JDBC Connection auf unsere H2 Datenbank
		 */
		Connection con = DriverManager.getConnection(config.getJdbcUrl(), config.getJdbcUsername(), config.getJdbcPassword()); 
		return con;
	}
}
