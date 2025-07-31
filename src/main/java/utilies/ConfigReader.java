package utilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\selenium-automation\\src\\main\\resources\\config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
