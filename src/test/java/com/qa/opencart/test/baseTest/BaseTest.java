package com.qa.opencart.test.baseTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.main.base.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    public BasePage basePage;
    public Properties prop;
    public Page page;

    @BeforeMethod
    public void setup() {
    basePage = new BasePage();
    prop = basePage.init_Properties();
    page = basePage.initBrowsers();
    }

    @AfterMethod
    public void tearDown(){
        page.context().browser().close();
    }
}
