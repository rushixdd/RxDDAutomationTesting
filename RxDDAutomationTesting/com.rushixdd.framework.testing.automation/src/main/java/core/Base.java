package core;

import org.openqa.selenium.WebDriver;

public class Base {
    private TestContext testContext;
    private WebDriverFactory webDriverFactory;

    public Base() {
        this.testContext = TestContextHolder.CONTEXT_HOLDER.getContext(); // Retrieve the existing TestContext
        this.webDriverFactory = new WebDriverFactory();
    }

    public void initializeWebDriver(String browser, String url, String driverPath) {
        if (testContext.getDriver() == null) {
            WebDriver driver = webDriverFactory.getDriver(browser, driverPath, url); // Use WebDriverFactory to create the driver
            TestContextHolder.CONTEXT_HOLDER.getContext().setDriver(driver);  // Set the WebDriver in the TestContext
        }
    }

    public void cleanup() {
        if (testContext.getDriver() != null) {
            testContext.getDriver().quit();  // Quit the WebDriver
            TestContextHolder.CONTEXT_HOLDER.removeContext(); // Clean up the context
        }
    }
}
