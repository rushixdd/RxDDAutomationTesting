package Config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Properties;
public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath= "config//Configuration.properties";

    public static String ParseJSON(String filePath, String key){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode jsonValue = rootNode.get(key);

            if (jsonValue != null) {
                return jsonValue.toString();
            } else {
                return "Key not found in JSON";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading JSON file";
        }
    }

    public static Properties ReadPropertiesFile(String filePath) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
