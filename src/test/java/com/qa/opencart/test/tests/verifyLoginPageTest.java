package com.qa.opencart.test.tests;

import com.qa.opencart.main.pages.HomePage;
import com.qa.opencart.main.pages.LoginPage;
import com.qa.opencart.test.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyLoginPageTest extends BaseTest {

    @Test
    public void navigateToSignInPage(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.clickOnSignInLink();
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Sign in or Register | eBay");

    }

    @Test
    public void loginToEbay(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.clickOnSignInLink();
        Assert.assertTrue(loginPage.verifyResetPasswordLinkIsVisible());
        Assert.assertTrue(loginPage.verifyResetPasswordLinkIsEnable());
        Assert.assertFalse(loginPage.verifyContinueButtonIsEnable());

        loginPage.doLogin(prop.getProperty("password"));
    }


}
