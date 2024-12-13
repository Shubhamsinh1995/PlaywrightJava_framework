package com.qa.pw.practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

public class EcomTask {

    @Test

    public void verify(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        Locator locator = page.getByAltText("Poco Electro");
        PlaywrightAssertions.assertThat(locator).hasText("Poco Electro");

        page.locator("(//a[@href= 'https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/blog/home'])[2]").click();

        // Scroll to the bottom of the page
        //page.evaluate("window.scrollTo(0, document.body.scrollHeight)");

        // Scroll back to the top of the page
        //page.evaluate("window.scrollTo(0, 0)");

        page.locator("(//a[contains(@href, 'https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/blog/article&article')])[1]").click();

        page.locator("#input-name").fill("Akshay");
        page.locator("#input-email").fill("testakshay2@gmail.com");
        page.locator("#input-comment").fill("practice comment to validate practice data for checking comment success message");

        page.locator("#button-comment").click();

        Locator successMessage = page.locator("//div[@class='alert alert-success alert-dismissible']");
        String fullText = successMessage.textContent().trim();
        PlaywrightAssertions.assertThat(successMessage).hasText(fullText);

    }

    @Test
    public void verifyFlipkart(){

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.flipkart.com/");
        PlaywrightAssertions.assertThat(page).hasTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");


        page.locator("//input[@name='q']").fill("laptop");
        page.keyboard().press("Enter");
        page.waitForTimeout(1000);

        page.locator("//a[text()='Login']").click();

        Locator field = page.locator("//input[@class='r4vIwl BV+Dqf']");
        field.click();
        field.fill("9730183655");
        page.locator("//button[text()='Request OTP']").click();
        page.waitForTimeout(3000);


    }
}
