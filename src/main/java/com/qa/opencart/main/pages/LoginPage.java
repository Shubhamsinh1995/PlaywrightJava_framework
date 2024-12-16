package com.qa.opencart.main.pages;

import com.qa.opencart.main.base.BasePage;

public class LoginPage extends BasePage {

    private String RESET_PASSWORD_LINK_XPATH = "//a[text()='Reset your password']";
    private String CONTINUE_BUTTON_XPATH = "//button[@id='sgnBt']";
    private String PASSWORD_FIELD_XPATH = "//button[@id='sgnBt']";
    private String SKIPP_LINK_XPATH = "//a[@id='passkeys-cancel-btn']";

    public String getLoginPageTitle(){
        String title = getTitle();
        System.out.println("Sign In page title is: "+title);
        return title;
    }

    public boolean verifyResetPasswordLinkIsVisible(){
        return verifyElementIsVisible(RESET_PASSWORD_LINK_XPATH);
    }
    public boolean verifyResetPasswordLinkIsEnable(){
        return verifyElementIsEnabled(RESET_PASSWORD_LINK_XPATH);
    }

    public boolean verifyContinueButtonIsEnable(){
        return verifyElementIsEnabled(CONTINUE_BUTTON_XPATH);
    }

    public void doLogin(String password){
        enterText(PASSWORD_FIELD_XPATH, password);
        clickOn(CONTINUE_BUTTON_XPATH, "Continue button");
        clickOn(SKIPP_LINK_XPATH, "skipp for now link");
    }
}
