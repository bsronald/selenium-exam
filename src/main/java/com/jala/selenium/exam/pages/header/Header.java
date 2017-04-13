package com.jala.selenium.exam.pages.header;

import com.jala.selenium.exam.common.CommonActions;
import com.jala.selenium.exam.pages.AbstractBasePage;
import com.jala.selenium.exam.pages.Account.Account;
import com.jala.selenium.exam.pages.dropdown.ProfileDropDownMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author bsronald on 4/12/17.
 */
public class Header extends AbstractBasePage {


    @FindBy(css = "div.tc_profile_dropdown a.tc_dropdown_name")
    private WebElement dropdownName;

    @FindBy(css = "ul[data-aid='MenuList']")
    private WebElement dropdownProfileMenu;


    /**
     *
     */
    public ProfileDropDownMenu clickOnProfileDropDownMenu() {
        CommonActions.clickElement(dropdownName);
        wait.until(ExpectedConditions.visibilityOf(dropdownProfileMenu));
        return new ProfileDropDownMenu();
    }


    /**
     *
     * @return
     */
    public Account navigateToAccounts() {
        ProfileDropDownMenu profileDropDownMenu = clickOnProfileDropDownMenu();
        return profileDropDownMenu.clickOnAccountLink();
    }




}
