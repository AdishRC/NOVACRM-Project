// ================= stepDefinitions/ForgotPasswordSteps.java =================
package stepDefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.en.*;
import pageObject.ForgotPasswordPage;
import pageObject.ResetPasswordPage;
import utils.EmailReader;
import utils.TestContextSetup;

public class ForgotPasswordSteps {
    TestContextSetup testContext;
    public Page page;
    ForgotPasswordPage forgotPage;
    ResetPasswordPage resetPage;

    public ForgotPasswordSteps(TestContextSetup testContext) {
        this.testContext = testContext;
        this.page = testContext.page;
    }

    @Given("User is on the Forgot Password page")
    public void navigateToForgotPassword() {
        forgotPage = new ForgotPasswordPage(page);
        forgotPage.navigateTo();
    }

    @When("User enters registered email and clicks Get Password")
    public void triggerResetEmail() {
        forgotPage.enterEmail("adish@mmnovatech.com");
        forgotPage.clickGetPassword();
    }

    @Then("User should receive a reset password email")
    public void waitForEmail() throws InterruptedException {
        Thread.sleep(10000); // Ideally replace with polling logic
    }

    @And("User clicks the reset link and sets a new password")
    public void clickResetLinkAndChangePassword() throws Exception {
        String resetLink = EmailReader.getResetLink(
                "imap-mail.outlook.com",
                "adish@mmnovatech.com",
                "AdiRam@789" // use app password or secure config
        );

        page.navigate(resetLink);
        resetPage = new ResetPasswordPage(page);
        resetPage.resetPassword("Adish@7845");
    }
}


