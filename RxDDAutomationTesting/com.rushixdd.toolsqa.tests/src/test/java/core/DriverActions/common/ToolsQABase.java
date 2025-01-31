package core.DriverActions.common;

import UtilitiyExtensions.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToolsQABase  extends Base{

    public ToolsQABase(){
    }

    public void NavigateToToolsqa(){
        this.driver.get("chrome://settings/");
        System.out.println("Navigate to ToolsQA");
    }
}