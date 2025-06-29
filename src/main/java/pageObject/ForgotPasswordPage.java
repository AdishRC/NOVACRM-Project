// ================= pageObject/ForgotPasswordPage.java =================
package pageObject;

import com.microsoft.playwright.Page;

public class ForgotPasswordPage {
    private final Page page;

    public ForgotPasswordPage(Page page) {
        this.page = page;
    }

    public void navigateTo() {
        page.navigate("https://app.novacrm.ca/forgot-password");
    }

    public void enterEmail(String email) {
        page.fill("//input[@id='email']", "adish@mmnovatech.com");
    }

    public void clickGetPassword() {
        page.click("//button[normalize-space()='Get your password']");
    }
}

