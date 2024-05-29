package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    public WebDriver driver;

    DriverManager(WebDriver driver){
        this.driver = driver;
    }
}
