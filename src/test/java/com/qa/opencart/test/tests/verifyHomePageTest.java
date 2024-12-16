package com.qa.opencart.test.tests;

import com.qa.opencart.main.pages.HomePage;
import com.qa.opencart.test.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyHomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLayout(){

        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getHomePageTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
        Assert.assertEquals(homePage.getPageURL(),prop.getProperty("url"));

        Assert.assertTrue(homePage.verifySignInLinkIsVisible());
        Assert.assertTrue(homePage.verifyEbayLogoIsVisible());
        Assert.assertTrue(homePage.verifySearchFieldDisplay());
        Assert.assertTrue(homePage.verifySearchButtonDisplay());
        Assert.assertTrue(homePage.verifyAdvancedButtonDisplay());
    }

    @Test
    public void searchTest(){
        HomePage homePage = new HomePage();
        homePage.searchForItem("iPhone 15");
        Assert.assertTrue(homePage.verifySearchResultstDisplayed());
    }



}
