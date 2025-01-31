package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

public class WebDriverFactory {

    public WebDriver getDriver(String browser, String path, String url) {
        WebDriver driver = createDriver(browser, path); // Create the browser driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to(url); // Navigate to the URL after driver is initialized
        return driver;
    }

    private WebDriver createDriver(String browser, String path) {
        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", path);
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", path);
                return new EdgeDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", path);
                return new ChromeDriver();
        }
    }
}
