package UtilitiyExtensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(WebDriver driver,By locator, WaitCondition condition, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(condition.getCondition(locator));
    }

    public WebElement waitForElement(By locator, WaitCondition condition) {
        return null;
    }
}