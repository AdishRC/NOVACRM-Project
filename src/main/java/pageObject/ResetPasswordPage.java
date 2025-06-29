// ================= pageObject/ResetPasswordPage.java =================
package pageObject;

import com.microsoft.playwright.Page;

public class ResetPasswordPage {
    private final Page page;

    public ResetPasswordPage(Page page) {
        this.page = page;
    }

    public void resetPassword(String newPassword) {
        page.fill("//input[@id='password']", "Adish@4680");
        page.fill("//input[@id='passwordConfirmation']", "Adish@4680");
        page.click("//button[normalize-space()='Reset Password']");
    }
}

