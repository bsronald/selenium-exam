package com.jala.selenium.exam.common;

import com.jala.selenium.exam.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * @author bsronald on 4/13/17.
 */
public class UICommonMethods {

    private static final WebDriver driver = DriverManager.getInstance().getDriver();

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
     *
     */
    public static void closeBrowser() {
        driver.quit();
    }
}
