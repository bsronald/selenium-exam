package com.jala.selenium.exam.pages.Account;

import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.pages.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author bsronald on 4/13/17.
 */
public class SubNavigationHeader extends AbstractBasePage {


    /**
     *
     */
    public SettingAccount clickOnSettings() {
        clikOnSubNav("Settings");
        return new SettingAccount();

    }

    /**
     *
     * @param name
     */
    private void clikOnSubNav(String name) {
        WebElement button = driver.findElement(By.xpath("//a[@class='button' and contains(.,'" + name + "')]"));
        CommonActions.clickElement(button);
    }
}
