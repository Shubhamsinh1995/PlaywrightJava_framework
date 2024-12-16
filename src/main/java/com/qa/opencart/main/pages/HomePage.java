package com.qa.opencart.main.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.opencart.main.base.BasePage;

public class HomePage extends BasePage {

    private final String SIGNIN_BUTTON_XPATH = "//span[@id='gh-ug']/a[text()='Sign in']";
    private final String REGISTER_BUTTON_XPATH = "//span[@id='gh-ug-flex']/a[text()='register']";
    private final String SEARCH_FIELD_XPATH = "//input[@id='gh-ac']";
    private final String SEARCH_BUTTON_XPATH = "//input[@type='submit']";
    private final String ADVANCED_BUTTON_XPATH = "//td[@id='gh-as-td']/a";

    private final String EBAY_LOGO_XPATH = "//*[name()='svg' and @id='gh-logo']";
    private final String SEARCH_RESULT_XPATH = "//ul[@class='srp-results srp-list clearfix']/li[@class='s-item s-item__pl-on-bottom']";



    public String getHomePageTitle(){
        String title = getTitle();
        return title;
    }

    public String getPageURL(){
        String title = getUrl();
        return title;
    }

    public boolean verifySearchFieldDisplay(){
        return verifyElementIsVisible(SEARCH_FIELD_XPATH);
    }

    public boolean verifySearchButtonDisplay(){
        return verifyElementIsVisible(SEARCH_BUTTON_XPATH);
    }

    public boolean verifyAdvancedButtonDisplay(){
        return verifyElementIsVisible(ADVANCED_BUTTON_XPATH);
    }

    public boolean verifySignInLinkIsVisible(){
        return verifyElementIsVisible(SIGNIN_BUTTON_XPATH);
    }

    public boolean verifyRegisterLinkIsVisible(){
        return verifyElementIsVisible(REGISTER_BUTTON_XPATH);
    }

    public boolean verifyEbayLogoIsVisible(){
        return verifyElementIsVisible(EBAY_LOGO_XPATH);
    }

    public LoginPage clickOnSignInLink(){
        clickOn(SIGNIN_BUTTON_XPATH, "SignIn link");
        return new LoginPage();
    }

    public void clickOnRegisterInLink(){
        clickOn(REGISTER_BUTTON_XPATH, "Register link");
    }

    public void clickOnSearchButton(){
        clickOn(SEARCH_BUTTON_XPATH, "Search Button");
    }

    public void clickOnAdvancedButton(){
        clickOn(ADVANCED_BUTTON_XPATH, "Search Button");
    }

    public void searchForItem(String itemName){
        enterText(SEARCH_FIELD_XPATH, itemName);
        clickOnSearchButton();
    }

    public Boolean verifySearchResultstDisplayed(){
        getPage().waitForTimeout(3000);
        Locator result = getLocator(SEARCH_RESULT_XPATH);
        return result.count() > 0;
    }




}
