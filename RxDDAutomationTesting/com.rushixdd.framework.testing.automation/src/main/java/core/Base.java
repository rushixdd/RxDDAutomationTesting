package core;

import org.openqa.selenium.WebDriver;

public class Base {
    private TestContextHolder testContextHolder;
    private TestContext testContext;
    private WebDriverFactory webDriverFactory;

    public Base() {
        this.testContextHolder = new TestContextHolder();
        this.testContext = testContextHolder.getContext(); // Retrieve the existing TestContext
        this.webDriverFactory = new WebDriverFactory(); // Initialize the WebDriverFactory
    }

    public void initializeWebDriver(String browser, String url, String driverPath) {
        if (testContext.getDriver() == null) {
            WebDriver driver = webDriverFactory.getDriver(browser, driverPath, url); // Use WebDriverFactory to create the driver
            testContext.setDriver(driver);  // Set the WebDriver in the TestContext
        }
    }

    public void cleanup() {
        if (testContext.getDriver() != null) {
            testContext.getDriver().quit();  // Quit the WebDriver
            testContextHolder.removeContext(); // Clean up the context
        }
    }
}
