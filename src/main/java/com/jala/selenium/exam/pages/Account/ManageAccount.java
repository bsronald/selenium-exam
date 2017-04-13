package com.jala.selenium.exam.pages.Account;


import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.pages.AbstractBasePage;
import com.jala.selenium.exam.pages.header.Header;
import com.jala.selenium.exam.pages.header.UserManagementHeader;
import com.jala.selenium.exam.utils.EnvironmentChecker;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class doing the manage the accounts.
 */
public class ManageAccount extends AbstractBasePage {
    @FindBy(css = "h2.account_name span")
    private WebElement accountNameLabel;

    final static Logger LOG = Logger.getLogger(EnvironmentChecker.class);
    private Header header;
    private UserManagementHeader managementHeader;
    private SubNavigationHeader subNavigation;
    private String accountId;

    public ManageAccount() {
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
     * This method doing click on "Setting" button.
     *
     * @param name String  whit the setting name.
     * @return SettingAccount page.
     */
    public SettingAccount clickOnAccountButtons(final String name) {
        WebElement settingButton = driver.findElement(By.cssSelector("a[href='" + name + "']"));
        CommonActions.clickElement(settingButton);
        return new SettingAccount();
    }

    /**
     * This method wait while loading element.
     */
    public void waitPage() {
        wait.until(ExpectedConditions.visibilityOf(accountNameLabel));
    }

    /**
     *
     * @return
     */
    public String getAccountName() {

        return accountNameLabel.getText();
    }


    /**
     *
     * @return
     */
    public String getAccountId() {
        waitPage();
        final String currentUrl = driver.getCurrentUrl();
        final String regex = "(?<=accounts\\/)([0-9]+)(?=\\/\\w+)";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(currentUrl);
        if (matcher.find()) {
            this.accountId = matcher.group(0);
        }
        LOG.debug("AccountId:" + this.accountId);
        return accountId;
    }

}
