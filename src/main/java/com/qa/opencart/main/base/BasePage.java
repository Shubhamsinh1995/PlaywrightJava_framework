package com.qa.opencart.main.base;

import com.microsoft.playwright.*;
import com.qa.opencart.main.container.Container;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage extends Container {

    private static Properties prop;
    private static Page page;
    private static Browser browser;
    private static BrowserContext browserContext;

    public BasePage(Page page){
        super(page);
        this.page =page;
    }

    public Page initBrowsers(){

        String browserName = prop.getProperty("browser").trim();
        System.out.println("Browser name is: "+ browserName);

        switch (browserName.toLowerCase()){
            case "chromium":
                browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "firefox":
                browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "webkit":
                browser = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            default:
                System.out.println("Please enter correct browserName...");
                break;

        }

        page = getPage();
        page.navigate(prop.getProperty("url"));
        System.out.println("Url is: "+prop.getProperty("url"));

        return page;

    }

  public static Page getPage(){
        browserContext = browser.newContext();
       return page = browserContext.newPage();
  }


    public Properties init_Properties(){

        try {
            prop = new Properties();
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config.properties");
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }


}
