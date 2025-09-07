package com.qa.opencart.test.tests.practice;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadInPlayWright {

    @Test
    public void uploadFiles(){
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("", new Page.NavigateOptions().setTimeout(60000));

        // upload file when have input tag and type=file
        page.locator("").setInputFiles(Path.of("file path"));


        // upload file when we don't have input tag
        FileChooser fileChooser = page.waitForFileChooser(() ->
            page.locator("").click()
        );
        fileChooser.setFiles(Paths.get("file path "));

      // To upload multiple files we pass Path array to setFiles() method
      Path [] fileuploads = {Paths.get("file path 1"),
                             Paths.get("file path 2"),
                             Paths.get("file path 3")};

      fileChooser.setFiles(fileuploads);

    }
}
