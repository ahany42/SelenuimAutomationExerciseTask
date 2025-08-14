import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static void loadProperties(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file: " + filePath);
        }
    }

    public static String get(String key) {
        if (properties == null) {
            throw new IllegalStateException("Properties file not loaded. Call loadProperties() first.");
        }
        return properties.getProperty(key);
    }
}
