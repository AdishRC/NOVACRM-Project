package pageObject;

import com.microsoft.playwright.Page;
public class LoginValidation {
    Page page;
    private final String invalidCredentialsLocator = "//p[@class='Login_fieldError__pMMFz']";

    //Logout Locators
    private final String clickOnAvtar = "//img[@alt='User Avatar']";
    private final String getText = "//p[@class='text-truncate ButtomHeader_username__miag8']";
    private final String logout = "//button[normalize-space()='Logout']";

    //Forgot Password Locators
    private final String forgotPasswordLink = "//a[normalize-space()='Forgot Password?']";
    private final String emailInput = "//input[@id='email']";
    private final String errorMessage = "//li[contains(text(),\"can't find\")]";
    private final String getYourPasswordButton = "//button[normalize-space()='Get your password']"; // Corrected - previously same as input!
    private final String backToLoginButton = "//button[normalize-space()='Back to Login']";

    public LoginValidation(Page page) {
        this.page = page;
    }

    public void enterCredentials(String username, String password) {
        page.fill("[placeholder='Enter your email']", username);
        page.fill("[placeholder='Enter your password']", password);
        System.out.println("Entered Username & Password");
    }

    public void clickLogin() {
        page.waitForTimeout(2000);
        page.click("xpath=//button[@type='submit']");
        page.waitForTimeout(2000);
        System.out.println("Clicked Login Button");
    }

    public void logout () {
        page.waitForTimeout(6000);
        page.locator(clickOnAvtar).click();
        page.waitForTimeout(2000);
        String userName = page.locator(getText).innerText();
        System.out.println("Account Holder Name: " + userName);
        page.locator(logout).click();
        System.out.println("Logout Successfully!!!");

    }

    public boolean isLoginFailed() {
        page.waitForTimeout(3000);
        return page.locator(invalidCredentialsLocator).isVisible();
    }
    public String getLoginErrorMessage() {
        if (isLoginFailed()) {
            return page.locator(invalidCredentialsLocator).innerText().trim();
        }
        return null;
    }

//====================================================== Forgot Password =========================================================

    public void clickForgotPassword() {
        page.waitForTimeout(3000);
        page.locator(forgotPasswordLink).click();
        System.out.println("Clicked on Forgot Password link");
    }

    public void enterEmail(String email) {
        page.waitForTimeout(3000);
        page.locator(emailInput).fill(email);
        System.out.println("Entered email: " + email);
    }

    public void clickGetYourPassword(String email) {
        page.waitForTimeout(2000);
        page.locator(getYourPasswordButton).click();
        System.out.println("Clicked Get Your Password button");

        if (email.contains("@") && email.contains(".")) {
            System.out.println("Valid email used: " + email);
        } else {

            page.waitForSelector(errorMessage, new Page.WaitForSelectorOptions().setTimeout(5000));
            String error = page.locator(errorMessage).innerText();
            System.out.println("Invalid email used: " + email);
            System.out.println("Error message: " + error);
        }
    }

    public void clickBackToLogin() {
        page.waitForTimeout(3000);
        page.locator(backToLoginButton).click();
        System.out.println("User successfully redirected to the Login page");
    }
}
