package com.qa.opencart.test.tests.practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class MultipleWindows_popups {

    @Test
    public void handleMultipleWindows(){

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.hyrtutorials.com/p/window-handles-practice.html", new Page.NavigateOptions().setTimeout(60000));
        //page.setDefaultNavigationTimeout(60000);

        page.locator("#newWindowBtn").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));

        /*// code to handle alerts in Playwright
        page.onDialog(dialog -> {
            dialog.accept();
            dialog.dismiss();
            dialog.accept("Prompt alertmessage");
        });*/


        Page popUp = page.waitForPopup(() -> {
            page.locator("#newWindowBtn").click();
        });

        popUp.bringToFront();
        String title =popUp.title();
        System.out.println(title);
        assertThat(popUp).hasTitle(title);
        popUp.close();

        page.bringToFront();
        page.locator("//input[@id='name']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
        page.locator("//input[@id='name']").fill("Shubham");
        page.waitForTimeout(5000);
        //page.getByLabel("");

       /* Frame child = page.frame("name");
        Frame parent = child.parentFrame();*/

        page.locator("#newTabBtn").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));

        Page newTab = page.waitForPopup(() -> {
            page.locator("#newTabBtn").click();
        });
        newTab.bringToFront();

        String Heading = newTab.locator("//h1[@class='post-title entry-title']").innerText().trim();
        System.out.println(Heading);
        Assert.assertEquals("AlertsDemo", Heading);

        assertThat(newTab.locator("//h1[@class='post-title entry-title']")).hasText("AlertsDemo");
        newTab.close();

        page.bringToFront();



    }
}
