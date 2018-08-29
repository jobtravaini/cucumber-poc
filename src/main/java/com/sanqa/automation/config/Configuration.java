package com.sanqa.automation.config;

import java.util.Properties;

public class Configuration {

    private static final Configuration INSTANCE = new Configuration();
    private static final String CHROME_DRIVER_PATH_PROPERTY = "CHROME_DRIVER_PATH";
    private static final String CONFIGURATION_FILE_NAME = "configuration.properties";

    private String chromeDriverPath;

    private Configuration() {
        try {
            Properties configuration = new Properties();
            configuration.load(Configuration.class.getClassLoader().getResourceAsStream(CONFIGURATION_FILE_NAME));

            chromeDriverPath = configuration.getProperty(CHROME_DRIVER_PATH_PROPERTY);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Configuration getInstance() {
        return INSTANCE;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

}
