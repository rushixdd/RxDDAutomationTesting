package Core.DriverActions.Common;

import Base.Base;
import Config.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class ToolsQABase extends Base{
    public ToolsQABase() throws IOException {
        Properties prop = ConfigReader.ReadPropertiesFile("");
        WebDriver driver = Base.GetDriver(ConfigReader.ParseJSON(prop.getProperty("JSONConfigPath"),"driver"));
    }
}