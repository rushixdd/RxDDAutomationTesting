package core.DriverActions.common;

public class ToolsQABase  extends Base{

    public ToolsQABase(){
        super();
    }
    public void NavigateToToolsqa(){
        this.driver.get("http://google.com/");
        System.out.println("Navigate to ToolsQA");
    }
}
