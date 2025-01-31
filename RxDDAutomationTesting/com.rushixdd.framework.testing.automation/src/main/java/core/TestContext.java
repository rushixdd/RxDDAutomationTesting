package core;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class TestContext {
    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Media captureScreenshot(String screenshotName) {
        try {
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            return MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot, screenshotName).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}