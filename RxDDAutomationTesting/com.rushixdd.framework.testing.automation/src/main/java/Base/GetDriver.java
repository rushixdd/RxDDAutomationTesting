package Base;

import Config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.file.Paths;


public class GetDriver {
    private static DriverManager driverManager;
    private static WebDriver driver;
    private static final String HUB_URL = ConfigManager.getProperty("selenium.grid.url");

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigManager.getProperty("browser");
            driver = createDriver(browser);
        }

        return driver;
    }

    public static WebDriver createDriver(String browser) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser.toLowerCase()) {
            case "chrome":
                String chromeDriverPath = Paths.get("drivers", "chromedriver.exe").toAbsolutePath().toString();
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.merge(capabilities);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", ConfigManager.getProperty("webdriver.ie.driver"));
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.merge(capabilities);
                driver = new InternetExplorerDriver(ieOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", ConfigManager.getProperty("webdriver.gecko.driver"));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.merge(capabilities);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported: " + browser);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}