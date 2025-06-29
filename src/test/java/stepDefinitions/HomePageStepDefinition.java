package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import pageObject.HomePage;
import utils.TestContextSetup;
import java.io.IOException;

public class HomePageStepDefinition {

    public Page page;
    public HomePage homePage;
    TestContextSetup testContext;

    public HomePageStepDefinition(TestContextSetup testContext) {
        this.testContext = testContext;
        this.page = testContext.page;
        this.homePage = new HomePage(testContext);
    }

    @Given("User logs in with valid credentials and lands on the dashboard page")
    public void user_logs_in_and_lands_on_dashboard() {
        try {
            testContext.testBase.login(); // Login happens here
        } catch (IOException e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

//    @When("User validates the search functionality with valid and invalid search terms")
//    public void user_validates_search_functionality() {
//        homePage.validateSearchFunctionality();
//    }
//
//    @Then("The results should be displayed appropriately")
//    public void results_should_be_displayed() {
//        System.out.println("Results displayed and verified.");
//    }


//    @When("User Validate Notification Bell icon notification message count displayed on homepage")
//    public void user_validate_notification_bell_icon_count() {
//        homePage.notificationCountMsg();
//    }
//
//    @Then("User Validate home page Notification Bell icon on click redirection")
//    public void user_validate_home_page_Notification_Bell_icon() {
//        homePage.notificationIcon();
//    }


//    @When("The user clicks on the \"Add a Person\" icon and fills in the mandatory fields")
//    public void user_clicks_on_the_Add_a_Person_icon() {
//        homePage.addNewLead();
//    }
//
//    @Then("The user click on \"Save Lead\" button to add new lead successfully")
//    public void new_lead_added_successfully() {
//    }



    @When("the user clicks on the {string} icon")
    public void the_user_clicks_on_the_icon(String string) {
        homePage.sendTextIcon();
    }
    @Then("the user enters a name or phone number")
    public void the_user_enters_a_name_or_phone_number() {
        homePage.enterName();
    }
    @And("writes a message and clicks on the {string} button to send the message to the user")
    public void writes_a_message_and_clicks_on_the_button_to_send_the_message_to_the_user(String string) {
        homePage.sendMessageButton();
    }
}

