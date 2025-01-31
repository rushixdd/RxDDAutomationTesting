package stepdefinitions.common;

import core.DriverActions.common.ToolsQABase;
import io.cucumber.java.en.*;
public class ToolsQABaseSteps {
    private ToolsQABase toolsQABase;

    public ToolsQABaseSteps(){
        this.toolsQABase = new ToolsQABase();
    }

    @Given("Navigate to toolsqa")
    public void NavigateToToolsqa(){
        this.toolsQABase.NavigateToToolsqa();
    }
}
