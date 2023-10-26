package Base;

import org.openqa.selenium.WebDriver;

public class Base {

    protected static WebDriver GetDriver(String browser) {
        return GetDriver.InvokeDriver(browser);
    }
}
