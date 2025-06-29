//package stepDefinitions;
//
//import com.microsoft.playwright.Page;
//import io.cucumber.java.en.*;
//import org.picocontainer.annotations.Inject;
//import pageObject.LoginValidation;
//import utils.TestContextSetup;
//
//public class LoginValidationStepDefinition {
//    public TestContextSetup TCS;
//    public Page page;
//    public LoginValidation loginValidation;
//
//    public LoginValidationStepDefinition(TestContextSetup TCS) {
//        this.TCS = TCS;
//        this.page = TCS.page;
//        this.loginValidation = new LoginValidation(page);
//    }
//
//    @Given("User is on login page")
//    public void user_is_on_login_page() {
//        page.navigate("https://app.novacrm.ca/");
//        System.out.println("Navigated to Login Page");
//    }
//
//    @When("User enters username {string} and password {string}")
//    public void user_enters_username_and_password(String username, String password) {
//        loginValidation.enterCredentials(username, password);
//
//
//    }
//
//    @Then("User clicks on login button")
//    public void user_clicks_on_login_button() {
//        loginValidation.clickLogin();
//        System.out.println(username, password);
//        if(validation)
//        {
//            System.out.println(Invalid Username or Password.)
//        }
//        else()
//        {
//            System.out.println("Login Successful!");
//        }
//    }
//
//    @And("Verify login success outcome")
//    public void verify_login_success_outcome() {
//        System.out.println("Login Successful!");
//    }
//
//    @And("Verify login failed outcome")
//    public void verify_login_failed_outcome() {
//        System.out.println("Login Failed as Expected!");
//    }
//}
//


package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObject.LoginValidation;
import utils.TestContextSetup;

import static org.testng.Assert.assertEquals;

public class LoginValidationStepDefinition {
    public TestContextSetup TCS;
    public Page page;
    public LoginValidation loginValidation;

    public LoginValidationStepDefinition(TestContextSetup TCS) {
        this.TCS = TCS;
        this.page = TCS.page;
        this.loginValidation = new LoginValidation(page);
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        page.navigate("https://app.novacrm.ca/");
        System.out.println("Navigated to Login Page");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginValidation.enterCredentials(username, password);
    }

    @Then("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginValidation.clickLogin();
        // No success message here — leave that to the next step
    }

    @And("Verify login success outcome")
    public void verify_login_success_outcome() {
        boolean loginFailed = loginValidation.isLoginFailed();
        if (loginFailed) {
            String error = loginValidation.getLoginErrorMessage();
            System.out.println("Login Failed with message: " + error);
            Assert.fail("Expected login to succeed but failed with message: " + error);
        } else {
            System.out.println("Login Successful!");
        }
    }

    @And("Verify login failed outcome")
    public void verify_login_failed_outcome() {
        String error = loginValidation.getLoginErrorMessage();
        System.out.println("Login failed as expected. Message: " + error);
        Assert.assertEquals("Invalid Username or Password.", error);
}

}