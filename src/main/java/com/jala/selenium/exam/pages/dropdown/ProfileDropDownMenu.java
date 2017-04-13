package com.jala.selenium.exam.pages.dropdown;

import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.pages.AbstractBasePage;
import com.jala.selenium.exam.pages.Account.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author bsronald on 4/12/17.
 */
public class ProfileDropDownMenu extends AbstractBasePage {


    @FindBy(css = "a[href='/accounts']")
    private WebElement accountLink;

    /**
     *
     * @return a Account page
     */
    public Account clickOnAccountLink() {
        CommonActions.clickElement(accountLink);
        return new Account();

    }
}
