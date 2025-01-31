package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.IOException;

public class ConfigReader {

    private Config config;

    public ConfigReader() {
        loadConfig();
    }

    private void loadConfig() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.json")) {
            if (inputStream != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                config = objectMapper.readValue(inputStream, Config.class);
            } else {
                throw new IOException("Configuration file not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter for the config
    public Config getConfig() {
        return config;
    }

    // Example method to get specific config value
    public String getBaseURL() {
        return config.getBaseURL();
    }
}
