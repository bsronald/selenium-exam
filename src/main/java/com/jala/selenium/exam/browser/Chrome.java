package com.jala.selenium.exam.browser;

import com.jala.selenium.exam.utils.EnvironmentChecker;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class initialize the Chrome Selenium Web Driver.
 */
public class Chrome implements Driver {

    private static final String WEB_DRIVER_PATH_WINDOWS = "src/main/resources/drivers/chromedriver.exe";
    private static final String  WEB_DRIVER_PATH_LINUX = "src/main/resources/drivers/chromeDriver";
    private static final String WEB_DRIVER_KEY = "webdriver.chrome.driver";
    private final static Logger LOG = Logger.getLogger(EnvironmentChecker.class);


    /**
     * {@inheritDoc}
     */
    @Override
    public final WebDriver initDriver() {
        final String webDriverPath = getWebDriverPath();
        System.setProperty(WEB_DRIVER_KEY, webDriverPath);
        return new ChromeDriver();
    }

    /**
     * This method return the webDriver path for each operation system
     * @return webdriver path
     */
    private String getWebDriverPath() {
        final String osName = EnvironmentChecker.getInstance().getOsName();
        switch (osName) {
            case "Windows": {
                return WEB_DRIVER_PATH_WINDOWS;
            }
            case "Linux": {
                return WEB_DRIVER_PATH_LINUX;
            }
            default: {
                LOG.error("Web driver path was not found for " + osName);
                System.exit(1);
                return null;
            }
        }
    }
}
