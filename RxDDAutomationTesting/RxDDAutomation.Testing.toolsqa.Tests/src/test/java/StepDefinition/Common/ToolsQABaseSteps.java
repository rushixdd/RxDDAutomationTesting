package StepDefinition.Common;

import Core.DriverActions.Common.ToolsQABase;
import io.cucumber.java.en.*;
public class ToolsQABaseSteps {

    private ToolsQABase toolsQABase;

    public ToolsQABaseSteps(ToolsQABase toolsQABase){
        this.toolsQABase = toolsQABase;
    }

    @Given("Navigate to toolsqa")
    public void NavigateToToolsqa(){
        this.toolsQABase.NavigateToToolsqa();
    }
}
