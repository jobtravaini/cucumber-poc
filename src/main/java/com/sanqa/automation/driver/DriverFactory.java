package com.sanqa.automation.driver;

import com.sanqa.automation.config.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class DriverFactory {

    private static final DriverFactory INSTANCE = new DriverFactory();
    private File chromeDriverExecutable;

    private DriverFactory() {
        instantiateChromeDriverExecutable();
    }

    public static DriverFactory getInstance() {
        return INSTANCE;
    }

    private void instantiateChromeDriverExecutable() {
        String chromeDriverPath = Configuration.getInstance().getChromeDriverPath();
        if(StringUtils.isNotEmpty(chromeDriverPath)) {
            chromeDriverExecutable = new File(chromeDriverPath);
        } else {
            throw new ExceptionInInitializerError("Chrome Driver path was not configured.");
        }
    }

    public WebDriverWrapper openChrome() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .usingDriverExecutable(chromeDriverExecutable)
                .build();

        ChromeDriver driver = new ChromeDriver(service);

        return new WebDriverWrapper(driver);
    }

}
