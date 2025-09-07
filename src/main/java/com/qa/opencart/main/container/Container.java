package com.qa.opencart.main.container;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Container {

    protected Page page;

    public Container(Page page){
        this.page =page;
    }

    public String getTitle(){
        String title = page.title();
        System.out.println("Title is: "+title);
        return title;
    }

    public String getUrl(){
        String url = page.url();
        System.out.println("URL is: "+url);
        return url;
    }

    public void clickOn(String locator, String elementName){
        page.locator(locator).click();
        System.out.println("Clicked on: "+elementName);
    }

    public String getAttribute(String selector, String name){
        return page.getAttribute(selector, name);
    }

    public String getAttribute(String selector, String name, Page.GetAttributeOptions option){
        return page.getAttribute(selector, name, option);
    }

    public String getText(String locator){
        String locatorText = page.textContent(locator).trim();
        return locatorText;
    }

    /*public void verifyDropDownValues(String locator, String drodownName){
        clickOn(locator, drodownName);

    }*/

    public void enterText(String locator, String text){
        page.locator(locator).fill(text);
    }

    public void waitForVisibility(String selector, int seconds){
        page.locator(selector).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(seconds * 1000));
    }

    public void waitForVisibility(Locator locator, int seconds){
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(seconds * 1000));
    }

    public Locator getLocator(String locator){
        Locator eleLocator = page.locator(locator);
        return eleLocator;
    }

    public Locator switchToFrameLocator(String frameLocator, String locator){
        Locator frameLoc = page.frameLocator(frameLocator).locator(locator);
        return frameLoc;
    }

    public void switchToFrame(String nameOrID){
        page.frame(nameOrID);
    }

    public boolean verifyElementIsVisible(String locator){
        return page.isVisible(locator);
    }

    public boolean verifyElementIsEnabled(String locator){
        return page.isEnabled(locator);
    }

    public boolean verifyElementIsDisabled(String locator){
        return page.isDisabled(locator);
    }

    public boolean verifyElementIsEditable(String locator){
        return page.isEditable(locator);
    }

    public boolean isElementChecked(String locator){
        return page.isChecked(locator);
    }
}
