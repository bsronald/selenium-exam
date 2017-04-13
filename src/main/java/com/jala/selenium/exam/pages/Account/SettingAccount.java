package com.jala.selenium.exam.pages.Account;


import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.common.UICommonMethods;
import com.jala.selenium.exam.pages.AbstractBasePage;
import com.jala.selenium.exam.pages.header.Header;
import com.jala.selenium.exam.pages.header.UserManagementHeader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class doing the manage the setting the account.
 */
public class SettingAccount extends AbstractBasePage {
    @FindBy(css = "a.button.current")
    private WebElement settingButton;
    @FindBy(css = "div.description > a")
    private WebElement deleteAccountLink;

    private Header header;
    private UserManagementHeader managementHeader;
    private SubNavigationHeader subNavigation;

    SettingAccount() {
        header = new Header();
        managementHeader = new UserManagementHeader();
        subNavigation = new SubNavigationHeader();
    }

    public SubNavigationHeader getSubNavigation() {
        return subNavigation;
    }

    public Header getHeader() {
        return header;
    }

    public UserManagementHeader getManagementHeader() {
        return managementHeader;
    }

    /**
     * This method doing click on "Ok alert Message" button.
     */
    private void clickOKAlertMessage() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method doing click on "Delete Account" link.
     */
    void clickDeleteAccountLink() {
        CommonActions.clickElement(deleteAccountLink);
        clickOKAlertMessage();
    }
}
