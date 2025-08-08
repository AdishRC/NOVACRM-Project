package stepDefinitions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObject.PeoplePage;
import utils.TestContextSetup;
import java.io.IOException;

public class PeoplePageStepDefinition {
    private final TestContextSetup testContext;
    private final Page page;
    private final PeoplePage peoplePage;

    public PeoplePageStepDefinition(TestContextSetup testContext) {
        this.testContext = testContext;
        this.page = testContext.page;
        this.peoplePage = new PeoplePage(testContext);
    }

    // =================================== Add New Lead StepDefinition =========================================
    @Given("the user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        try {
            testContext.testBase.login();
        } catch (IOException e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    @When("the user clicks on the {string} tab in the top menu")
    public void the_user_clicks_on_the_tab_in_the_top_menu(String tabName) {
        if (tabName.equalsIgnoreCase("People")) {
            peoplePage.navigateToPeoplePage();
        } else {
            throw new UnsupportedOperationException("Tab not implemented: " + tabName);
        }
    }

    @When("the user clicks on the {string} icon")
    public void the_user_clicks_on_the_icon(String iconName) {
        if (iconName.equalsIgnoreCase("Add a Person")) {
            peoplePage.clickAddPersonIcon();
        } else {
            throw new UnsupportedOperationException("Icon not implemented: " + iconName);
        }
    }

    @Then("the {string} modal should appear, the user fills in the required fields, and clicks the {string} button")
    public void the_modal_should_appear_user_fills_fields_and_clicks_button(String modalName, String buttonName) {
        if (modalName.equalsIgnoreCase("Add New Lead") && buttonName.equalsIgnoreCase("Save Lead")) {
            peoplePage.createNewLead();
        } else {
            throw new UnsupportedOperationException("Modal/button action not implemented for: " + modalName + "/" + buttonName);
        }
    }

    // =================================== Batch Text StepDefinition =========================================
    @Then("the user select lead and click on Batch Text icon on bottom")
    public void the_user_select_lead_and_click_on_batch_text_icon_on_bottom() {
        peoplePage.selectLeadAndOpenBatchText();
    }

    @When("the user send text with Use Template")
    public void the_user_send_text_with_use_template() {
        peoplePage.batchTextUseTemplate();
    }

    @Then("the user back from the batch text page")
    public void the_user_back_from_the_batch_text_page() {
        peoplePage.backPage();
    }

    @When("the user send text with Create Text Template")
    public void the_user_send_text_with_create_text_template() {
        peoplePage.batchTextCreateTemplate();
    }

    // =================================== Send Mail StepDefinition =========================================
    @Then("the user select lead and click on Send Mail icon on bottom")
    public void the_user_select_lead_and_click_on_send_mail_icon_on_bottom() {
        peoplePage.selectLeadAndOpenMail();
    }

    @When("the user send mail from Use Template")
    public void the_user_send_mail_from_use_template() {
        peoplePage.sendMailUseTemplate();
    }

    @Then("the user back from the Email Marketing page")
    public void the_user_back_from_the_email_marketing_page() {
        peoplePage.backPageEmailMarketing();
    }

    @When("the user Send Mail from NOVA AI")
    public void the_user_send_mail_from_nova_ai() {
        peoplePage.sendMailNOVA_AI();
    }


    // =================================== Add Remove Tag StepDefinition =========================================
    @Then("the user select lead and click on Tags icon on bottom")
    public void the_user_select_lead_and_click_on_tags_icon_on_bottom() {
        peoplePage.selectLeadAndClickTag();
    }

    @Then("the user create the tag and add new tag")
    public void the_user_create_the_tag_and_add_new_tag() {
        peoplePage.selectLeadAndAddTag();
    }

    @When("the user select and remove the tag")
    public void the_user_select_and_remove_the_tag() {
        peoplePage.selectLeadAndRemoveTag();
    }


    // =================================== More Actions StepDefinition =========================================

    @Then("the user selects a lead and clicks the {string} icon at the bottom")
    public void the_user_selects_a_lead_and_clicks_the_icon_at_the_bottom(String string) {
        peoplePage.selectLeadAndClickMoreActions();
    }

    @When("the user selects {string} and performs the update")
    public void the_user_selects_and_performs_the_update(String string) {
        peoplePage.setUpdateStage();
    }

    @When("the user selects {string} and perform the update")
    public void the_user_selects_and_perform_the_update(String string) {
        peoplePage.setUpdateSource();
    }

    @When("the user selects {string} and assigns an agent")
    public void the_user_selects_and_assigns_an_agent(String string) {
        peoplePage.setAssignAgent();
    }


    // =================================== Custom Filter StepDefinition =========================================
    @Then("the user performs the First Name filter")
    public void the_user_performs_the_first_name_filter() {
     peoplePage.selectFirstName_startwith();
     peoplePage.selectFirstName_isempty();
     peoplePage.selectFirstName_contain();
    }

    @Then("the user performs the Last Name filter")
    public void the_user_performs_the_last_name_filter() {
        peoplePage.selectLastName_startwith();
        peoplePage.selectLastName_isempty();
        peoplePage.selectLastName_contain();
    }

    @Then("the user performs the Email filter")
    public void the_user_performs_the_email_filter() {
        peoplePage.selectEmail_startwith();
        peoplePage.selectEmail_isempty();
        peoplePage.selectEmail_contain();
    }
    @Then("the user performs the Phone filter")
    public void the_user_performs_the_phone_filter() {
        peoplePage.selectPhone_startwith();
        peoplePage.selectPhone_isempty();
        peoplePage.selectPhone_contain();
    }


    @Then("the user performs the Stages filter")
    public void the_user_performs_the_stages_filter() {
        peoplePage.selectStage_include();
        peoplePage.selectStage_exclude();
        peoplePage.selectStage_is_empty();
        peoplePage.selectStage_is_not_empty();
    }


    @When("the user performs the Tags filter")
    public void the_user_performs_the_tags_filter() {
        peoplePage.selectTags_include();
        peoplePage.selectTags_exclude();
        peoplePage.selectTags_is_empty();
        peoplePage.selectTags_is_not_empty();
    }


    @When("the user performs the Source filter")
    public void the_user_performs_the_source_filter() {
        peoplePage.selectSource_include();
        peoplePage.selectSource_exclude();
        peoplePage.selectSource_is_empty();
        peoplePage.selectSource_is_not_empty();
    }


    @When("the user performs the Lead Type filter")
    public void the_user_performs_the_lead_type_filter() {
        peoplePage.selectLead_Type_include();
        peoplePage.selectLead_Type_exclude();
        peoplePage.selectLead_Type_is_empty();
        peoplePage.selectLead_Type_is_not_empty();
    }


    @When("the user performs the Last Communication filter")
    public void the_user_performs_the_last_communication_filter() {
        peoplePage.selectInclude();
        peoplePage.selectExclude();
        peoplePage.select_is_empty();
        peoplePage.select_is_not_empty();//
        peoplePage.select_less_than();
        peoplePage.select_more_than();
    }

    @When("the user performs the Created filter")
    public void the_user_performs_the_created_filter() {
        peoplePage.applyCreatedLessThanFilter();
        peoplePage.applyCreatedMoreThanFilter();
    }

    // =================================== Import People StepDefinition ===============================================
    @When("the user clicks on the {string} button and uploads a valid file")
    public void the_user_clicks_on_the_button_and_uploads_a_valid_file(String string) {
        peoplePage.importpeople();
    }
    @When("the user fills in all mandatory fields and clicks the {string} button")
    public void the_user_fills_in_all_mandatory_fields_and_clicks_the_button(String string) {
        peoplePage.fillMandatoryField();
    }
    @When("the user selects or adds tags")
    public void the_user_selects_or_adds_tags() {
        peoplePage.tagsField();
    }
    @Then("the user clicks the {string} button and the lead is imported successfully")
    public void the_user_clicks_the_button_and_the_lead_is_imported_successfully(String string) {
        peoplePage.submit();
    }

    @Then("the user check the CSV Status")
    public void the_user_check_the_CSV_Status() {
        peoplePage.openCheckCsvStatus();
    }

    // ================================= Add & Edit Lead Details StepDefinition ====================================
    @Then("the user selects a lead from the list")
    public void the_user_selects_a_lead_from_the_list() {
     peoplePage.selectLead();
    }
    @Then("the user performs a call to the lead")
    public void the_user_performs_a_call_to_the_lead() {
        peoplePage.leadCall();
    }
    @When("the user sends a text message to the lead")
    public void the_user_sends_a_text_message_to_the_lead() {
       peoplePage.sendTextMessage();
    }
    @Then("the user sends an email to the lead")
    public void the_user_sends_an_email_to_the_lead() {
        peoplePage.sendEmail();
    }
    @Then("the user add the lead details")
    public void the_user_add_the_lead_details() {
            peoplePage.addLeadDetails();
    }
}

