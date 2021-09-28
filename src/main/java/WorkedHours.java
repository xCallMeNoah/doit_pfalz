import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkedHours {

	/**
	 * Einspeisung der Daten in unsere Applikation und Ausgabe dessen Daten
	 * 
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public String printPersonWithHours(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		/**
		 * ResultSet greift mit executeQuery auf die Datenbank zu mit dem select Befehl.
		 * Der Select Befehl greift auf die erstellte View von uns zurück und gruppiert diese Daten nach Personen ID.
		 */
		ResultSet rs = stmt.executeQuery("SELECT ID, VORNAME, NACHNAME, SUM(WORKED_HOURS) WORKED_HOURS"
				+ " FROM WORKEDHOURS_PERSON GROUP BY ID;");
		String output = "";
		while(rs.next()) {
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			Double worked_hours = rs.getDouble("worked_hours");
			output += vorname + " " + nachname + " " + worked_hours + "\n";
		}
		return output;
	}
}
