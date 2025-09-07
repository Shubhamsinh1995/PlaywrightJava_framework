package com.qa.opencart.test.tests.practice;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class DownloadFiles {

    @Test
    public void downloadFile(){

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("", new Page.NavigateOptions().setTimeout(60000));



        Download filedownload = page.waitForDownload(() -> {

            page.locator("xpath of download link").click();
        });
        String filepath = System.getProperty("user.dir")+"/downloads/"+ filedownload.suggestedFilename();
        filedownload.saveAs(Paths.get(filepath));
        if (filepath.endsWith(".txr")){
            System.out.println("file extension verified");
        }
    }
}
