//package pageObject;
//
//import com.microsoft.playwright.Page;
//
//public class LoginValidation {
//    Page page;
//
//    private final String invalidCredentials = "//p[@class='Login_fieldError__pMMFz']";
//
//
//
//    public LoginValidation(Page page) {
//        this.page = page;
//    }
//
//    public void enterCredentials(String username, String password) {
//        page.fill("[placeholder='Enter your email']", username);
//        page.fill("[placeholder='Enter your password']", password);
//        System.out.println("Entered Username & Password");
//    }
//
//    public void clickLogin() {
//        page.click("xpath=//button[@type='submit']");
//        System.out.println("Clicked Login Button");
//        page.locator(invalidCredentials).getAttribute("Invalid Username or Password.");
//        String validation = invalidCredentials;
//    }
//}


//
//package pageObject;
//
//import com.microsoft.playwright.Page;
//
//public class LoginValidation {
//    Page page;
//
//    private final String invalidCredentialsLocator = "//p[@class='Login_fieldError__pMMFz']";
//
//    public LoginValidation(Page page) {
//        this.page = page;
//    }
//
//    public void enterCredentials(String username, String password) {
//        page.fill("[placeholder='Enter your email']", username);
//        page.fill("[placeholder='Enter your password']", password);
//        System.out.println("Entered Username & Password");
//    }
//
//    public void clickLogin() {
//        page.click("xpath=//button[@type='submit']");
//        System.out.println("Clicked Login Button");
//    }
//
//    public boolean isLoginFailed() {
//        return page.locator(invalidCredentialsLocator).isVisible();
//    }
//
//    public String getLoginErrorMessage() {
//        if (isLoginFailed()) {
//            return page.locator(invalidCredentialsLocator).innerText();
//        }
//        return null;
//    }
//}

package pageObject;

import com.microsoft.playwright.Page;

public class LoginValidation {
    Page page;
    private final String invalidCredentialsLocator = "//p[@class='Login_fieldError__pMMFz']";

    public LoginValidation(Page page) {
        this.page = page;
    }

    public void enterCredentials(String username, String password) {
        page.fill("[placeholder='Enter your email']", username);
        page.fill("[placeholder='Enter your password']", password);
        System.out.println("Entered Username & Password");
    }

    public void clickLogin() {
        page.click("xpath=//button[@type='submit']");
        System.out.println("Clicked Login Button");

        // Optional: wait briefly for error to appear
        page.waitForTimeout(2000); // Wait 2 seconds
    }

    public boolean isLoginFailed() {
        return page.locator(invalidCredentialsLocator).isVisible();
    }

    public String getLoginErrorMessage() {
        if (isLoginFailed()) {
            return page.locator(invalidCredentialsLocator).innerText().trim();
        }
        return null;
    }
}
