package com.qa.opencart.main.util;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.opencart.main.base.BasePage;

public class Utility extends BasePage {

    private static Page page;

    public Utility(Page page) {
        super();
        this.page = page;
    }


}
