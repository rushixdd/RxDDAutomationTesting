package core.DriverActions.common;

import core.TestContextHolder;
import org.openqa.selenium.WebDriver;

public abstract class Base {
    WebDriver driver;

    public Base() {
        this.driver = TestContextHolder.CONTEXT_HOLDER.getContext().getDriver();
    }
}