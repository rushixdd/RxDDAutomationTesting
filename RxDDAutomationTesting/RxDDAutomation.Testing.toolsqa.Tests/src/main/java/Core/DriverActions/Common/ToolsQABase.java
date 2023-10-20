package Core.DriverActions.Common;

import Base.Base;
import org.openqa.selenium.WebDriver;

public abstract class ToolsQABase extends Base{
    public ToolsQABase(){
        WebDriver driver = Base.GetDriver();
    }
}