package binding;

import core.Base;
import core.TestContextHolder;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.java.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(features = {"src/test/java/Features"} , plugin = {"json:target/cucumber.json", "pretty"},
        glue = "stepdefinitions")
public class HookInitialize {

    private TestContextHolder testContextHolder; // Renamed variable
    private Base base;

    public HookInitialize() {
        this.base = new Base(); // Initialize Base which will handle WebDriver setup and cleanup
    }

    @BeforeTest
    public void BeforeSuite() {
        System.out.println("Suite is Starting");
    }

    @AfterTest
    public void AfterSuite() {
        System.out.println("Test Suite Executed Successfully");
    }

    @Before
    public void BeforeScenario() {
        base.initializeWebDriver("chrome", "https://www.toolsqa.com", "C:\\Users\\realr\\Downloads\\chromedriver-win64\\chromedriver.exe");
        System.out.println("Test is Starting");
    }

    @After
    public void AfterScenario() {
        base.cleanup(); // Cleanup WebDriver and context after scenario
        System.out.println("Test Executed Successfully");
    }

    @BeforeStep
    public void BeforeMethod() {
        System.out.println("Test Case is Starting");
    }

    @AfterStep
    public void AfterMethod() {
        System.out.println("Test Case Executed Successfully");
    }

    public void Test1() {
        System.out.println("Class Test 1");
    }
}