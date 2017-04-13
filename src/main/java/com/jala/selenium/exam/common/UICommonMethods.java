package com.jala.selenium.exam.common;

import com.jala.selenium.exam.browser.DriverManager;
import com.jala.selenium.exam.utils.EnvironmentChecker;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * @author bsronald on 4/13/17.
 */
public class UICommonMethods {

    private static final WebDriver driver = DriverManager.getInstance().getDriver();
    final static Logger LOG = Logger.getLogger(UICommonMethods.class);

    /**
     * This method try to find a web element in the web page
     *
     * @param by element to search
     * @return true if the element is found and false if this
     * is not founded
     */
    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Close the browser
     */
    public static void closeBrowser() {
        driver.quit();
    }


    /**
     * This method make a refresh.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * The driver wait to a element disappear
     *
     * @param maxCount number of times to wait
     * @param element  to search
     * @return true or false
     */
    @SuppressWarnings("SameParameterValue")
    public static boolean waitElementIsNotPresent(int maxCount, By element) {
        boolean result = true;
        int count = 1;
        try {
            LOG.info("Wait Element is not present ->" + element.toString());
            while (result && count <= maxCount) {
                Thread.sleep(300);
                result = isElementPresent(element);
                count++;
            }
        } catch (InterruptedException e) {
            LOG.error("Exception Element is not Present" + e);
        }
        return !result;
    }

    /**
     * The driver wait to find a element
     *
     * @param maxCount number of times to wait
     * @param by       to search
     * @return true or false
     */
    public static boolean waitElementIsPresent(int maxCount, By by) {
        boolean result = false;
        int count = 1;
        LOG.info("Wait Element is present ->" + by.toString());
        while (!result && count <= maxCount) {
            result = isElementPresent(by);
            count++;
        }
        return result;
    }
}
