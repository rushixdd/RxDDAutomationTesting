package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class GetDriver {

    protected static WebDriver InvokeDriver(String driverBrowser){
        return switch (driverBrowser) {
            case "InternetExplorer" -> GetIEDriver();
            case "FireFox" -> GetFirefoxDriver();
            default -> GetChromeDriver();
        };
    }
    private static ChromeOptions GetChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        return options;
    }

    private static WebDriver GetChromeDriver(){
        return new ChromeDriver();
    }

    private static WebDriver GetIEDriver(){
        return new InternetExplorerDriver();
    }

    private static WebDriver GetFirefoxDriver(){
        return new FirefoxDriver();
    }
}
