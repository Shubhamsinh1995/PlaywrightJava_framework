package com.qa.opencart.main.util;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.opencart.main.base.BasePage;

import java.nio.file.Paths;
import java.util.Base64;

public class Utility extends BasePage {

    private static Page page;

    public Utility(Page page) {
        super();
        this.page = page;
    }


    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }

}
