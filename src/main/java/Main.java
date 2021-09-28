import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		/**
		 * Properties Loader
		 */
		PropLoader prop = new PropLoader();
		
		/**
		 * Erstellung der Instanz der AppConfig mittels Properties
		 */
		AppConfig config = AppConfig.getInstance(prop.getPropValues());
		/**
		 * Verbindung zur Datenbank erstellen - übergabe der Config
		 */
		Connection con = JDBCDriverManager.getJDBCConnection(config);
		/**
		 * Ausgabe der Werte in der Datenbank in der Console
		 */
		WorkedHours hours = new WorkedHours();
		System.out.println(hours.printPersonWithHours(con));
	}

}
