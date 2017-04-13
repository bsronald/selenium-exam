package com.jala.selenium.exam.pages.Account;


import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.common.UICommonMethods;
import com.jala.selenium.exam.pages.AbstractBasePage;
import com.jala.selenium.exam.pages.header.Header;
import com.jala.selenium.exam.pages.header.UserManagementHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This is the Account page class.
 */
public class Account extends AbstractBasePage {

    private static final String MANAGE_ACCOUNT = "MANAGE ACCOUNT";
    private Header header;
    private UserManagementHeader managementHeader;

    @FindBy(id = "new_account_link")
    private WebElement createAccountButton;

    @FindBy(id = "add_account_button")
    private WebElement addAccountButton;

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(className = "header_button")
    private List<WebElement> manageAccountButtonList;


    public Account() {
        header = new Header();
        managementHeader = new UserManagementHeader();
    }

    public Header getHeader() {
        return header;
    }

    public UserManagementHeader getManagementHeader() {
        return managementHeader;
    }

    /**
     * This method set the account name in the text field.
     *
     * @param accountName String  whit the account name.
     */
    private void setAccountNameTextField(final String accountName) {
        CommonActions.setTextField(accountNameTextField, accountName);
    }

    /**
     * This method do click on "Manage Account" button.
     *
     * @param manageAccountButton WebElement that represent a "Management Account".
     * @return ManageAccount page.
     */
    private ManageAccount clickManageAccount(final WebElement manageAccountButton) {
        CommonActions.clickElement(manageAccountButton);
        return new ManageAccount();
    }

    /**
     * This method doing click on "Create Account" button.
     */
    private void clickCreateAccountButton() {
        CommonActions.clickElement(createAccountButton);
    }

    /**
     * This method added a new account.
     *
     * @return ManageAccount page.
     */
    private ManageAccount clickAddAccountButton() {
        CommonActions.clickElement(addAccountButton);
        return new ManageAccount();
    }

    /**
     * This method created a new account.
     *
     * @param accountName String  whit the account name.
     * @return ManageAccount page.
     */
    public ManageAccount createAccount(final String accountName) {
        clickCreateAccountButton();
        setAccountNameTextField(accountName);
        return clickAddAccountButton();
    }

    /**
     * This method deleted all accounts.
     *
     * @param accountList List the elements to deleted.
     * @return Return true if deleted all projects.
     */
    public boolean deleteAllAccounts(final List<WebElement> accountList) {
        if (!accountList.isEmpty()) {
            int index = 1;
            WebElement webElement = accountList.get(index);
            String text = webElement.getText();
            if (text.equals(MANAGE_ACCOUNT)) {
                deleteAccount(webElement);
            }
            return deleteAllAccounts(getManageAccountButtonList());
        }
        return true;
    }

    /**
     * This method deleted account.
     *
     * @param webElement WebElement for delete account.
     */
    private void deleteAccount(final WebElement webElement) {
        String attributeValue = webElement.getAttribute("href");
        attributeValue = attributeValue.replace("plans", "settings");
        int indexOf = attributeValue.indexOf("/accounts");
        attributeValue = attributeValue.substring(indexOf);
        ManageAccount manageAccount = clickManageAccount(webElement);
        SettingAccount settingAccount = manageAccount.clickOnAccountButtons(attributeValue);
        settingAccount.clickDeleteAccountLink();
    }

    /**
     * This method obtains a of WebElement list.
     *
     * @return List the WebElement the button type.
     */
    public List<WebElement> getManageAccountButtonList() {
        return manageAccountButtonList;
    }


    /**
     * This method verify if the account created was displayed
     *
     * @param accountNameExpected name of the account
     * @return true if was displayed, otherwise false
     */
    public boolean isAccountCreatedDisplayed(String accountNameExpected) {
        By accountName = By.xpath("//div[@class='name' and contains(., '" + accountNameExpected + "')]");
        return UICommonMethods.isElementPresent(accountName);
    }

    /**
     * This method navigate to Manage Account for an account
     * @param accountId account id
     */
    public ManageAccount navigateToManageAccount(String accountId) {
        WebElement accountManageButton = driver.findElement(By.id("manage_account_link_" + accountId  + ""));
        CommonActions.clickElement(accountManageButton);
        return new ManageAccount();
    }

    /**
     * Delete an account
     * @param accountId
     */
    public void deleteAccount(String accountId) {
        ManageAccount manageAccount = navigateToManageAccount(accountId);
        SettingAccount settingAccount = manageAccount.getSubNavigation().clickOnSettings();
        settingAccount.clickDeleteAccountLink();
        UICommonMethods.waitElementIsPresent(3, By.id("new_account_link"));
    }
}
