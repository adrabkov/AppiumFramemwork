package core.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class Configurations {
    protected final Logger log = Logger.getLogger("AD");
    protected final String osName = getProperty("OS");
    protected final String application = getFile(getProperty("application")).getAbsolutePath();
    protected final String deviceName = getProperty("deviceName");
    protected final String iOsPlatformVersion = getProperty("iOsPlatformVersion");
    protected final String androidPlatformVersion = getProperty("androidPlatformVersion");

    private String getProperty(String propertyName) {
        Properties property = new Properties();
        try (InputStream inputStream = new FileInputStream(getFile("config.properties"))) {
            property.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return property.getProperty(propertyName);
    }

    private File getFile(String fileName) {
        return new File(new File(getPathToDir()), fileName);
    }

    private String getPathToDir() {
        var baseDir = System.getProperty("user.dir");
        return Paths.get(baseDir, "src", "test", "resources").toString();
    }
}
