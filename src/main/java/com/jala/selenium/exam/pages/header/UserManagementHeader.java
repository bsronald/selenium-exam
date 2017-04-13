package com.jala.selenium.exam.pages.header;

import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.pages.AbstractBasePage;
import com.jala.selenium.exam.pages.Account.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author bsronald on 4/12/17.
 */
public class UserManagementHeader extends AbstractBasePage {

    public static final String ACCOUNT = "accounts";


    /**
     * This method doing click on "Setting" button.
     *
     * @param name String  whit the setting name.
     * @return SettingAccount page.
     */
    private void clickOnLink(final String name) {
        WebElement settingButton = driver.findElement(By.cssSelector("a[href='/" + name + "']"));
        CommonActions.clickElement(settingButton);
    }

    /**
     *
     * @return
     */
    public Account clickOnAccount() {
        clickOnLink(ACCOUNT);
        return new Account();
    }
}
