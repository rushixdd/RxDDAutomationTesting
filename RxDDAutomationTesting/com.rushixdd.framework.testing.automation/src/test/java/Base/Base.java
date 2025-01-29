package Base;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {
    WebDriver driver;
    DriverManager testDriver = new DriverManager(driver);

    Base(){
        this.testDriver.driver = GetDriver.getDriver();
    }

    @Test
    public void testDriverInitialization() {
        Assert.assertNotNull(this.testDriver.driver);
        Assert.assertTrue(this.testDriver.driver instanceof WebDriver);
    }

    @AfterClass
    public void tearDown() {
        GetDriver.quitDriver();
    }

}
