package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Browser {
    private WebDriver driver;
    private String driverPath;

    public Browser() {
        // Azure Pipelines'ında dinamik olarak belirlenen driver yolunu kullanma
        String azureDriverPath = System.getenv("DRIVER_PATH");
        if (azureDriverPath == null || azureDriverPath.isEmpty()) {
            this.driverPath = Paths.get("src", "main", "resources", "drivers").toString();
        } else {
            this.driverPath = azureDriverPath;
        }
    }

    public WebDriver getDriver(String browserType, boolean disableNotifications) {
        try {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", Paths.get(driverPath, "chromedriver").toString());
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (disableNotifications) {
                        chromeOptions.setExperimentalOption("prefs", prefs);
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver", Paths.get(driverPath, "geckodriver").toString());
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver", Paths.get(driverPath, "msedgedriver").toString());
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }

            if (driver == null) {
                throw new NullPointerException("Failed to initialize WebDriver for browser: " + browserType);
            }

            // Tarayıcı penceresini tam ekran yap
            driver.manage().window().maximize();
            return driver;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing WebDriver for browser type: " + browserType, e);
        }
    }

//    @BeforeScenario
//    public void setUp() {
//        // Setup işlemlerini buraya ekleyebilirsiniz
//    }
//
//    @AfterSuite
//    public void closeDriver() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
