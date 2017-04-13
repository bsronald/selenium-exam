package com.jala.selenium.exam.pages;


import com.jala.selenium.exam.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 10/12/2016.
 */
public class Welcome extends AbstractBasePage {
    @FindBy(css = "div.header__lg > a[href='/signin']")
    private WebElement signinLink;

    /**
     * This method to clicks on the "Signin" button.
     *
     * @return Return to SignInForm page.
     */
    public SignInForm clickSigninLink() {
        CommonActions.clickElement(signinLink);
        return new SignInForm();
    }
}
