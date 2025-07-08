//package stepDefinitions;
//
//import com.microsoft.playwright.Page;
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//import pageObject.LoginValidation;
//import utils.TestContextSetup;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//import static org.testng.Assert.assertEquals;
//
//public class LoginValidationStepDefinition {
//    public TestContextSetup TCS;
//    public Page page;
//    public LoginValidation loginValidation;
//
//    Properties prop;
//    String testEmail;
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
//
//    @When("User enters valid credentials")
//    public void user_enters_valid_credentials() throws IOException {
//        Properties prop = new Properties();
//        FileInputStream fis = new FileInputStream("src/test/java/resource/global.properties");
//        prop.load(fis);
//
//        String username = prop.getProperty("Username");
//        String password = prop.getProperty("Password");
//
//        loginValidation.enterCredentials(username, password);
//    }
//
//    @Then("User clicks on login button")
//    public void user_clicks_on_login_button() {
//        loginValidation.clickLogin();
//    }
//
//    @And("Verify login success outcome")
//    public void verify_login_success_outcome() {
//        boolean loginFailed = loginValidation.isLoginFailed();
//        if (loginFailed) {
//            String error = loginValidation.getLoginErrorMessage();
//            System.out.println("Login Failed with message: " + error);
//            Assert.fail("Expected login to succeed but failed with message: " + error);
//        } else {
//            System.out.println("Login Successful!");
//        }
//    }
//
//    @And("User Logout from the system")
//    public void user_logout_from_the_system() {
//        loginValidation.logout();
//    }
//
//    @And("Verify login failed outcome")
//    public void verify_login_failed_outcome() {
//        String error = loginValidation.getLoginErrorMessage();
//        System.out.println("Login failed as expected. Message: " + error);
//        Assert.assertEquals("Invalid Username or Password.", error);
//}
//
//// ====================================================== Forgot Password ===========================================================
//
//@When("the user clicks on the {string} link")
//public void the_user_clicks_on_the_link(String linkName) {
//    if (linkName.equalsIgnoreCase("Forgot Password")) {
//        loginValidation.clickForgotPassword();
//    } else {
//        throw new IllegalArgumentException("Unknown link: " + linkName);
//    }
//}
//
//    @Then("the user is redirected to the Forgot Password page")
//    public void the_user_is_redirected_to_the_forgot_password_page() {
//        System.out.println("User is on Forgot Password page");
//    }
//
//    @Then("the user enters the email address")
//    public void the_user_enters_the_email_address() {
//        // Use the SAME properties you loaded in constructor
//        testEmail = prop.getProperty("forgotPasswordEmail");
//        loginValidation.enterEmail(testEmail);
//    }
//
//    @Then("the user clicks the {string} button")
//    public void the_user_clicks_the_button(String buttonName) {
//        switch (buttonName) {
//            case "Get Your Password":
//                loginValidation.clickGetYourPassword(testEmail); // Now testEmail is shared!
//                break;
//            case "Back to Login":
//                loginValidation.clickBackToLogin();
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown button: " + buttonName);
//        }
//    }
//
//}
//




package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObject.LoginValidation;
import utils.TestContextSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginValidationStepDefinition {
    public TestContextSetup TCS;
    public Page page;
    public LoginValidation loginValidation;

    Properties prop;
    String testEmail;

    public LoginValidationStepDefinition(TestContextSetup TCS) {
        this.TCS = TCS;
        this.page = TCS.page;
        this.loginValidation = new LoginValidation(page);

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/java/resource/global.properties");
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file");
        }
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        page.navigate("https://app.novacrm.ca/");
        System.out.println("Navigated to Login Page");
    }

    // ✅ For valid login (from properties)
    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        String username = prop.getProperty("Username");
        String password = prop.getProperty("Password");
        loginValidation.enterCredentials(username, password);
    }

    // ✅ For Scenario Outline: Unsuccessful Login
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        System.out.println("Trying with Username: " + username + " and Password: " + password);
        loginValidation.enterCredentials(username, password);
    }

    @Then("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginValidation.clickLogin();
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

    @And("User Logout from the system")
    public void user_logout_from_the_system() {
        loginValidation.logout();
    }

    @And("Verify login failed outcome")
    public void verify_login_failed_outcome() {
        String error = loginValidation.getLoginErrorMessage();
        System.out.println("Login failed as expected. Message: " + error);
        Assert.assertEquals(error, "Invalid Username or Password.");
    }

    // =================================== Forgot Password ===================================

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String linkName) {
        if (linkName.equalsIgnoreCase("Forgot Password")) {
            loginValidation.clickForgotPassword();
        } else {
            throw new IllegalArgumentException("Unknown link: " + linkName);
        }
    }

    @Then("the user is redirected to the Forgot Password page")
    public void the_user_is_redirected_to_the_forgot_password_page() {
        System.out.println("User is on Forgot Password page");
    }

    @Then("the user enters the email address")
    public void the_user_enters_the_email_address() {
        testEmail = prop.getProperty("forgotPasswordEmail");
        System.out.println("Using Forgot Password Email: " + testEmail);
        loginValidation.enterEmail(testEmail);
    }

    @Then("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonName) {
        switch (buttonName) {
            case "Get Your Password":
                loginValidation.clickGetYourPassword(testEmail);
                break;
            case "Back to Login":
                loginValidation.clickBackToLogin();
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }
}
