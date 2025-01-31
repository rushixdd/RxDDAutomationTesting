package UtilitiyExtensions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils extends Waiter{
    // Default timeout value (using static enum)
    private static final TimeoutDuration DEFAULT_TIMEOUT = TimeoutDuration.SECOND_60;  // Default 60 seconds

    // Private constructor to prevent instantiation
    private WaitUtils() {
    }

    // Static method to create WebDriverWait
    private static WebDriverWait getWait(WebDriver driver, TimeoutDuration timeout) {
        return new WebDriverWait(driver, Duration.ofMillis(timeout.getMilliseconds()));
    }

    // Static method to wait for a custom condition to be met (e.g., element load) with a default condition (visibility)
    public static WebElement waitForElementToLoad(WebDriver driver, By locator, ExpectedCondition<WebElement> condition) {
        if (condition == null) {
            // Default condition: Wait for element to be visible
            condition = ExpectedConditions.visibilityOfElementLocated(locator);
        }
        WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
        return wait.until(condition);
    }

    // Static method to wait for an element to be visible
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Static method to wait for an element to be clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Static method to wait for an element to be present in the DOM
    public static WebElement waitForElementPresence(WebDriver driver, By locator) {
        WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Static method to wait for an element to disappear from the DOM
    public static boolean waitForElementToDisappear(WebDriver driver, By locator) {
        try {
            WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Static method to wait for a specific condition to be true
    public static WebElement waitForCondition(WebDriver driver, ExpectedCondition<WebElement> condition) {
        WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
        return wait.until(condition);
    }

    // Static method to wait for alert to be present
    public static Alert waitForAlert(WebDriver driver) {
        WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // Static method to wait for page load by waiting for the document.readyState to be complete
    public static void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = getWait(driver, DEFAULT_TIMEOUT);
        wait.until(driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete"));
    }

    // Static method to check if the element is visible
    public static boolean isElementVisible(WebDriver driver, By locator) {
        try {
            waitForElementToBeVisible(driver, locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Static method to check if the element is clickable
    public static boolean isElementClickable(WebDriver driver, By locator) {
        try {
            waitForElementToBeClickable(driver, locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}