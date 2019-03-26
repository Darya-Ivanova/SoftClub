package core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static String browserType;
    private static String email;
    private static String password;
    private static FileInputStream propertiesFile;
    private static Properties property;

    static {
        property = new Properties();
        try {
            propertiesFile = new FileInputStream("src/main/resources/test.properties");
            property.load(propertiesFile);
            browserType = property.getProperty("browser.name");
            email = property.getProperty("email");
            password = property.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowserType() {
        return browserType;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}
