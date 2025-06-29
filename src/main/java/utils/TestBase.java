package utils;

import com.microsoft.playwright.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Page initializePage() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resource/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String browserName = prop.getProperty("Browser").toLowerCase();
        String url = prop.getProperty("TestUrl");
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized"));

        if (browserName.contains("chrome")) {
            browser = playwright.chromium().launch(launchOptions.setChannel("chrome"));
        } else if (browserName.contains("firefox")) {
            browser = playwright.firefox().launch(launchOptions);
        } else if (browserName.contains("webkit")) {
            browser = playwright.webkit().launch(launchOptions);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
        page.navigate(url);

        return page;
    }

    public void login() throws IOException {
        if (page == null) initializePage();

        FileInputStream fis = new FileInputStream("src/test/java/resource/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String username = prop.getProperty("Username");
        String password = prop.getProperty("Password");

        page.fill("[placeholder='Enter your email']", username);
        page.fill("[placeholder='Enter your password']", password);
        page.click("xpath=//button[@type='submit']");
    }

    public void closeBrowser() {
        if (context != null) {
            context.close();
            context = null;
        }
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
        page = null;
    }

    public Page getPage() {
        return page;
    }
}

