import java.util.Properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppConfig {

	private String csvexport;
	private String jdbcUsername;
	private String jdbcPassword;
	private String jdbcUrl;
	private Properties properties;
	private static AppConfig instance;

	/**
	 * Auslesen der Properties File und übergabe in den Einzelnen Strings über
	 * Constructor
	 * 
	 * @param propFilePath
	 */
	private AppConfig(Properties properties) {
		this.properties = properties;
		csvexport = properties.getProperty("csv.export");
		jdbcUsername = properties.getProperty("jdbc.username");
		jdbcPassword = properties.getProperty("jdbc.password");
		jdbcUrl = properties.getProperty("jdbc.url");
	}
	/**
	 * Erstellung der Instanz (Lazy Singleton)
	 * 
	 * @param properties
	 * @return
	 */
	public static AppConfig getInstance(Properties properties) {
		if (instance == null) {
			instance = new AppConfig(properties);
		}
		return instance;
	}

	/**
	 * Rückgabe eines Property Wertes, welcher sich gewünscht wird
	 * 
	 * @param propertyName
	 * @return
	 */
	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

}
