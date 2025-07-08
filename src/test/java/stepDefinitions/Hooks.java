//package stepDefinitions;
//
//import io.cucumber.java.After;
//import utils.TestContextSetup;
//
//public class Hooks {
//    TestContextSetup context;
//
//    public Hooks(TestContextSetup context) {
//        this.context = context;
//    }
//
//    @After
//    public void tearDown() {
//        context.testBase.closeBrowser();
//    }
//}


//package stepDefinitions;
//
//import com.microsoft.playwright.*;
//import io.cucumber.java.Before;
//import java.util.Arrays;
//
//public class Hooks {
//    public static Playwright playwright;
//    public static Browser browser;
//    public static BrowserContext context;
//    public static Page page;
//
//    @Before
//    public void setUp() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//
//        context = browser.newContext();
//
//        // ✅ ✔️ Correct: pass origin with GrantPermissionsOptions
//        context.grantPermissions(
//                Arrays.asList("microphone"),
//                new BrowserContext.GrantPermissionsOptions().setOrigin("https://app.novacrm.ca")
//        );
//
//        page = context.newPage();
//
//        page.navigate("https://app.novacrm.ca");
//    }
//}




