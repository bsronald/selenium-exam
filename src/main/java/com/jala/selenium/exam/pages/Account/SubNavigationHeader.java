package com.jala.selenium.exam.pages.Account;

import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.pages.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author bsronald on 4/13/17.
 */
public class SubNavigationHeader extends AbstractBasePage {


    private static final String SETTINGS = "Settings";

    /**
     * This method click on settings button
     */
    public SettingAccount clickOnSettings() {
        clickOnSubNav(SETTINGS);
        return new SettingAccount();

    }

    /**
     * This method click on a button Sub navigation header
     * @param name button name
     */
    private void clickOnSubNav(String name) {
        WebElement button = driver.findElement(By.xpath("//a[@class='button' and contains(.,'" + name + "')]"));
        CommonActions.clickElement(button);
    }
}
