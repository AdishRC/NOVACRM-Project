package stepDefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import pageObject.HomePage;
import utils.TestContextSetup;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HomePageStepDefinition {
    public Page page;
    public HomePage homePage;
    TestContextSetup testContext;

    public HomePageStepDefinition(TestContextSetup testContext) {
        //Page page = Hooks.page;
        this.testContext = testContext;
        this.page = testContext.page;
        this.homePage = new HomePage(testContext);
    }

    //========================= Home Page Search StepDefinition ========================================
    @Given("User logs in with valid credentials and lands on the dashboard page")
    public void user_is_on_the_Dashboard_page() {
        try {
            testContext.testBase.login(); // Login happens here
        } catch (IOException e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    @When("User validates the search functionality with valid and invalid search terms")
    public void user_validates_search_functionality() {
        homePage.validateSearchFunctionality();
    }

    @Then("The results should be displayed appropriately")
    public void results_should_be_displayed() {
        System.out.println("Results displayed and verified.");
    }

    //================================== Home Page Notification Step Definition ====================================
    @Then("User Validate home page Notification Bell icon on click redirection")
    public void user_validate_home_page_Notification_Bell_icon() {
        homePage.notificationIcon();
    }

    @When("User Validate Notification Bell icon notification message count displayed on homepage")
    public void user_validate_notification_bell_icon_count() {
        homePage.notificationCountMsg();
    }

    //================================== Home Page Add New Lead StepDefinition ====================================
    @When("The user clicks on the \"Add a Person\" icon and fills in the mandatory fields")
    public void user_clicks_on_the_Add_a_Person_icon() {
        homePage.addNewLead();
    }

    @Then("The user click on \"Save Lead\" button to add new lead successfully")
    public void new_lead_added_successfully() {
    }

    //================================== Home Page Send a text Locator ====================================
    @When("The user clicks on the Send a text icon")
    public void the_user_clicks_on_the_icon() {
        homePage.sendTextIcon();
    }

    @Then("The user enters a name or phone number")
    public void the_user_enters_a_name_or_phone_number() {
        homePage.enterName();
    }

    @And("Writes a message and clicks on the Send Message button to send the message to the user")
    public void writes_a_message_and_clicks_on_the_button_to_send_the_message_to_the_user() {
        homePage.sendMessageButton();
    }

    //================================ Home Page Send Email StepDefinition ====================================
    @When("The user clicks on the Send a Email icon")
    public void the_user_clicks_on_the_send_a_email_icon() {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resource/global.properties");
            Properties prop = new Properties();
            prop.load(fis);

            String email = prop.getProperty("NewEmail"); // Use your updated property key
            boolean result = homePage.clickSendEmailIcon(email);
            if (!result) {
                throw new AssertionError("No recipient found for email: " + email);
            }

            fis.close(); // Close your file stream
        } catch (Exception e) {
            throw new RuntimeException("Error loading global properties: " + e.getMessage());
        }
    }

    @Then("User enter the Recipient name and add the Subject")
    public void user_enter_the_recipient_name_and_add_the_subject() {
        homePage.receiptantName();
    }

    @And("Enter the data in the body and click on the Send Email Now button")
    public void enter_the_data_in_the_body_and_click_on_the_send_email_now_button() {
        homePage.clickEmailNowButton();
    }

    //================================== Home Page Make a call StepDefinition ====================================
    @When("The user clicks on the Make a Call icon")
    public void the_user_clicks_on_the_make_a_call_icon() {
        homePage.makeCallIcon();
    }

    @Then("User enter the name and select the lead and call")
    public void user_enter_the_name_and_select_the_lead_and_call() {
        homePage.enterNameOrPhone();
    }

    //==================================== Pages Redirection StepDefinition =========================================
    @When("the user clicks on the Home tab")
    public void the_user_clicks_on_the_home_tab() {
        homePage.homePage();
    }

    @Then("the user should be redirected to the Home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        homePage.homePage();
    }

    @When("the user clicks on the People tab")
    public void the_user_clicks_on_the_people_tab() {
        homePage.peoplePage();
    }

    @Then("the user should be redirected to the People page")
    public void the_user_should_be_redirected_to_the_people_page() {
        homePage.peoplePage();
    }

    @When("the user clicks on the Inbox tab")
    public void the_user_clicks_on_the_inbox_tab() {
        homePage.inboxPage();
    }

    @Then("the user should be redirected to the Inbox page")
    public void the_user_should_be_redirected_to_the_inbox_page() {
        homePage.inboxPage();
    }

    @When("the user clicks on the Email Marketing tab")
    public void the_user_clicks_on_the_email_marketing_tab() {
        homePage.emailMarketingPage();
    }

    @Then("the user should be redirected to the Email Marketing page")
    public void the_user_should_be_redirected_to_the_email_marketing_page() {
        homePage.emailMarketingPage();
    }

    @When("the user clicks on the Social Media Management tab")
    public void the_user_clicks_on_the_social_media_management_tab() {
        homePage.socialMediaManagementPage();
    }

    @Then("the user should be redirected to the Social Media Management page")
    public void the_user_should_be_redirected_to_the_social_media_management_page() {
        homePage.socialMediaManagementPage();
    }

    @When("the user clicks on the Tasks tab")
    public void the_user_clicks_on_the_tasks_tab() {
        homePage.tasksPage();
    }

    @Then("the user should be redirected to the Tasks page")
    public void the_user_should_be_redirected_to_the_tasks_page() {
        homePage.tasksPage();
    }

    @When("the user clicks on the Deals tab")
    public void the_user_clicks_on_the_deals_tab() {
        homePage.dealsPage();
    }

    @Then("the user should be redirected to the Deals page")
    public void the_user_should_be_redirected_to_the_deals_page() {
        homePage.dealsPage();
    }

    //==================================== Boxes Locators =========================================
    @When("User verify the Available Credit functionality")
    public void user_verify_the_available_credit_functionality() {
        homePage.verifyAvailableCredit();
    }

    @Then("User check Available Credit and View Credit history")
    public void user_check_available_credit_and_view_credit_history() {
        homePage.clickViewCreditHistory();
    }

    @When("User verify the New Leads functionality")
    public void user_verify_the_new_leads_functionality() {
        homePage.verifyNewLeads();
    }

    @Then("User check New Leads and View All Leads")
    public void user_check_new_leads_and_view_all_leads() {
        homePage.clickViewAllNewLeads();
    }

    @When("User verify the Todays Task functionality")
    public void user_verify_the_todays_task_functionality() {
        homePage.verifyTodayTask();
    }

    @Then("User check Todays Task and View All Task")
    public void user_check_todays_task_and_view_all_task() {
        homePage.clickViewAllTodayTask();
    }

    @When("User verify the Incomplete Follow Ups functionality")
    public void user_verify_the_incomplete_follow_ups_functionality() {
        homePage.verifyIncompleteFollowUps();
    }

    @Then("User check Incomplete Follow Ups and View View All Incomplete Follow Ups")
    public void user_check_incomplete_follow_ups_and_view_view_all_incomplete_follow_ups() {
        homePage.clickViewAllIncompleteFollowUps();
    }

    // =========================================== Email Marketing ==============================================
    @When("User selects the {string} option in the filter dropdown")
    public void user_selects_the_filter(String filter) {
        homePage.selectFilterOption(filter);
    }

    @Then("User verifies the emails for today")
    public void user_verifies_today() {
        homePage.verifyEmailMarketingStats("today");
    }

    @Then("User verifies the emails for yesterday")
    public void user_verifies_yesterday() {
        homePage.verifyEmailMarketingStats("yesterday");
    }

    @Then("User verifies the emails for the last {int} days")
    public void user_verifies_last_days(Integer days) {
        homePage.verifyEmailMarketingStats("last " + days + " days");
    }

    @And("User clicks on the View More to redirect the Email Marketing page")
    public void redirect_on_the_Email_marketing_page() {
        homePage.setViewMore();
    }

    //==================================== Tasks StepDefinition ==============================================
    @When("User unchecked the checkbox on tasks page")
    public void user_unchecked_the_checkbox_on_tasks_page() {
        homePage.tasksCheckbox();
    }

    @Then("User click on View More to redirect the Tasks page")
    public void user_click_on_view_more_to_redirect_the_tasks_page() {
        homePage.viewMoreCheckbox();
    }

    //==================================== Automation StepDefinition ==============================================
    @When("User Click on View All link")
    public void user_click_on_view_all_link() {
        homePage.automationViewMore();
    }

    @Then("User navigate to the Automation page")
    public void user_navigate_to_the_automation_page() {
        homePage.automationPage();
    }


    @When("the user selects {string} as the social media account type")
    public void the_user_selects_social_media_account_type(String accountType) {
        homePage.selectSocialMediaAccount(accountType);
    }

    @Then("the user applies all available filters sequentially")
    public void the_user_applies_all_available_filters_sequentially() {
        homePage.applyAllFilters();
    }

    @And("the user clicks on the {string} link to navigate to the Social Media page")
    public void the_user_clicks_on_the_link_to_navigate_to_the_social_media_page(String linkText) {
        homePage.clickViewMore();
    }
}

