package com.qa.opencart.test.tests.practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.annotations.Test;

public class HandleAlerts {
    @Test
    public void handleAlerts(){
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.hyrtutorials.com/p/window-handles-practice.html", new Page.NavigateOptions().setTimeout(60000));
        //page.setDefaultNavigationTimeout(60000);

        page.locator("#newWindowBtn").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
        page.locator("#newWindowBtn").click();

        // code to handle alerts in Playwright
        page.onceDialog(dialog -> {
            dialog.accept();
            dialog.dismiss();
            dialog.accept("Prompt alertmessage");
        });
    }
}
