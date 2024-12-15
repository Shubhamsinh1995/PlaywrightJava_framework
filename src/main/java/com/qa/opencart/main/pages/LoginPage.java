package com.qa.opencart.main.pages;

import com.microsoft.playwright.Page;
import com.qa.opencart.main.base.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(Page page) {
        super(page);
    }

    public String getLoginPageTitle(){
        String title = getTitle();
        System.out.println("Home page title is: "+title);
        return title;
    }
}
