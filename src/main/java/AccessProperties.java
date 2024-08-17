import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AccessProperties {

	public static String accessPropertiesValues(String propertyName) throws IOException {
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\resources\\url.properties");
		Properties p = new Properties();
		p.load(reader);

		String value = p.getProperty(propertyName);

		return value;
	}

}
