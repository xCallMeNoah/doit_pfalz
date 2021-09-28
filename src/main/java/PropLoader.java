import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropLoader {
	
	/**
	 * Properties Datei vom Resources Ordner versuchen zu bekommen
	 * Danach wird die Datei ausgelesen und zurück gegeben
	 * @return
	 * @throws IOException
	 */
	public Properties getPropValues() throws IOException {
		try(InputStream iS = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			Properties prop = new Properties();
			if(iS != null) {
				System.out.println("Config Datei gefunden!"
						+ "\nConfig Datei wird nun geladen... \n");
				prop.load(iS);
			}
			iS.close();
			return prop;
		}
	}
}
