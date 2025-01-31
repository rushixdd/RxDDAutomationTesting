package core.DriverActions.common;

import core.TestContextHolder;
import org.openqa.selenium.WebDriver;

public abstract class Base {
    private TestContextHolder testContextHolder;
    WebDriver driver;

    public Base() {
        this.testContextHolder = new TestContextHolder();
        driver = testContextHolder.getContext().getDriver();
    }
}