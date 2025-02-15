package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(String filePath) {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}