package com.qa.opencart.main.base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import com.qa.opencart.main.container.Container;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage extends Container {

    public Properties prop;

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public BasePage(){
        super(getPage());
    }


     public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }



    public Page initBrowsers(){

        String browserName = prop.getProperty("browser").trim();
        System.out.println("Browser name is: "+ browserName);

        tlPlaywright.set(Playwright.create());

        switch (browserName.toLowerCase()){
            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;

            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;

            case "webkit":
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;

            case "chrome":
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;

            default:
                System.out.println("Please provide the correct browserName...");
                break;

        }

        tlBrowserContext.set(getBrowser().newContext());
        tlPage.set(getBrowserContext().newPage());
        /*int []  screenSize = (int[]) getPage().evaluate("() => [window.screen.width, window.screen.height]", int[].class);
        int width = screenSize[0];
        int height = screenSize[1];*/
        getPage().setViewportSize(1366, 768);
        getPage().navigate(prop.getProperty("url"), new Page.NavigateOptions().setTimeout(60000));

        return getPage();
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
