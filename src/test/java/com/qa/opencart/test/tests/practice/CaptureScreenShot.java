package com.qa.opencart.test.tests.practice;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.Base64;

public class CaptureScreenShot {

    @Test

    public void captureScreenshot(){
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("", new Page.NavigateOptions().setTimeout(60000));

        String path = System.getProperty("user.dir") + "/screenshot/"+System.currentTimeMillis() +".png";
        byte[] screenShot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get(path)).setTimeout(5000));
        String Base64ScreenShot = Base64.getEncoder().encodeToString(screenShot);
    }
}
