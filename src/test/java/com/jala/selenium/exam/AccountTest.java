package com.jala.selenium.exam;

import com.jala.selenium.exam.common.UICommonMethods;
import com.jala.selenium.exam.pages.Account.Account;
import com.jala.selenium.exam.pages.Account.ManageAccount;
import com.jala.selenium.exam.pages.Dashboard;
import com.jala.selenium.exam.pages.SignInForm;
import com.jala.selenium.exam.utils.Environment;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author bsronald on 4/12/17.
 */
public class AccountTest {

    private Dashboard dashboard;
    private ManageAccount manageAccount;
    private Account account;
    private String accountId;
    private Environment environment = Environment.getInstance();

    @BeforeTest
    public void setup() {
        final String username = environment.getPrimaryUser();
        final String password = environment.getPrimaryPassword();
        dashboard = SignInForm.loginAs(username, password);

    }


    @Test
    public void testCreateAccount() {
        // Given
        account = dashboard.getHeader().navigateToAccounts();

        // When
        final String accountNameExpected = "Testing Account";
        manageAccount = account.createAccount(accountNameExpected);
        final String accountNameFound = manageAccount.getAccountName();
        accountId = manageAccount.getAccountId();

        // Then
        Assert.assertEquals(accountNameFound, accountNameExpected, "Account Names are not equals");
        account = manageAccount.getManagementHeader().clickOnAccount();
        Assert.assertTrue(account.isAccountCreatedDisplayed(accountNameExpected));



    }

    @AfterTest
    public void testTearDown() {
        account.deleteAccount(accountId);
        UICommonMethods.closeBrowser();
    }
}
