package Binding;

import Base.DriverManager;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.java.*;

@CucumberOptions(features = {"src/test/java/Features"} , plugin = {"json:target/cucumber.json", "pretty"},
        glue = "StepDefinition")
public class HookInitialize {

    private DriverManager testDriver;

    HookInitialize(DriverManager testDriver){
        this.testDriver=testDriver;
    }
    private TestNGCucumberRunner testNGCucumberRunner;
    @BeforeAll()
    public void BeforeSuite(){
        System.out.println("Suite is Starting");
    }

    @AfterAll()
    public void AfterSuite(){
        System.out.println("Test Suite Executed Successfully");
    }

    @Before()
    public void BeforeScenario(){
        System.out.println("Test is Starting");
    }

    @After
    public void AfterScenario(){
        testDriver.driver.quit();
        System.out.println("Test Executed Successfully");
    }

    @BeforeStep
    public void BeforeMethod(){
        System.out.println("Test Case is Starting");
    }

    @AfterStep
    public void AfterMethod(){
        System.out.println("Test Case Executed Successfully");
    }

    public void Test1(){
        System.out.println("Class Test 1");
    }
}