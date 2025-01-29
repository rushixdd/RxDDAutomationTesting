package UtilitiyExtensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public enum WaitCondition {
    VISIBILITY {
        @Override
        public Function<WebDriver, WebElement> getCondition(By locator) {
            return ExpectedConditions.visibilityOfElementLocated(locator);
        }
    },
    CLICKABLE {
        @Override
        public Function<WebDriver, WebElement> getCondition(By locator) {
            return ExpectedConditions.elementToBeClickable(locator);
        }
    },
    PRESENCE {
        @Override
        public Function<WebDriver, WebElement> getCondition(By locator) {
            return ExpectedConditions.presenceOfElementLocated(locator);
        }
    };

    public abstract Function<WebDriver, WebElement> getCondition(By locator);
}