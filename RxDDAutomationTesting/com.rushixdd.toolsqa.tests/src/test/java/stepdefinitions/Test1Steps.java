package stepdefinitions;

import io.cucumber.java.en.When;
public class Test1Steps {
    public Test1Steps(){
    }


    @When("Click on edit")
    public void click_on_edit() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Create new page")
    public void create_new_page(){
        System.out.println("Create Page");
    }
}
