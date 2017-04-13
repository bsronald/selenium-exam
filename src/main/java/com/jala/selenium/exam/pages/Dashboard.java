package com.jala.selenium.exam.pages;


import com.jala.selenium.exam.pages.Account.Account;
import com.jala.selenium.exam.pages.header.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Dashboard page the PivotalTracker.
 */
public class Dashboard extends AbstractBasePage {

    private Header header;
    @FindBy(id = "create_new_project_button")
    private WebElement createProjectButton;

    @FindBy(id = "my_projects_list")
    private WebElement projectsList;

    @FindBy(id = "create_new_workspace_button")
    private WebElement createWorkspaceLink;

    @FindBy(css = "li[id=\"notice\"]")
    private WebElement messageDeleteWorkspace;


    public Dashboard() {
        header = new Header();
    }

    public Header getHeader() {
        return header;
    }




}
