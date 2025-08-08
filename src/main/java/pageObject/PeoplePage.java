package pageObject;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import utils.TestContextSetup;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.*;

import com.microsoft.playwright.options.LoadState;

public class PeoplePage {
    private final Page page;
    private final Properties prop;

    // ============================= Add new Lead Locators =======================================================
    private final String peopleTab = "//span[normalize-space()='People']";
    private final String addPersonIcon = "//button[@class='btn nova-bg-sky bottom-header-icon ']";
    private final String firstName = "//input[@placeholder='First name *']";
    private final String lastName = "//input[contains(@placeholder,'Last name')]";
    private final String emailAddress = "//input[@placeholder='Email Address *']";
    private final String duplicateEmailAddress = "//span[normalize-space()='The email address has already been taken.']";
    private final String countryCode = "//select[@id='country_code']";
    private final String phoneNo = "//input[@placeholder='Phone No. *']";
    private final String duplicatePhoneNo = "//span[normalize-space()='The contact number has already been taken.']";
    private final String saveLead = "//button[normalize-space()='Save Lead']";

    // ============================== Batch Text with Use Template locators =======================================
    private final String selectLead = "//tbody/tr[2]/td[1]/label[1]/span[1]/span[1]";
    private final String batchTextIcon = "(//button[contains(@class,'selected-people-panel-button')])[1]";
    private final String useTemplate = "//p[contains(@class,'text-white pt-3 ps-3')]";
    private final String newBuyersLead = "//span[normalize-space()='New Buyer Leads (85)']";
    private final String followupReminder = "//li[normalize-space()='Follow-Up Reminder']";
    private final String sendButton = "//button[normalize-space()='Send']";
    private final String backButton = "//i[@class='fa-solid fa-arrow-left nova-bg-primary back_arrow_btn rounded-5 ']";

    // ================================ Batch Text from Create Text Template locators =================================
    private final String templateName = "//input[@id='tempId']";
    private final String messageBody = "//textarea[@id='messageBody']";

    // ================================ Send Mail with from Use Template locators ===========================
    private final String sendMail = "//div[@class='selected-people-button-panel']//button[2]";
    private final String useTemplateMail = "//p[@class='text-white pt-3 ps-3']";
    private final String housingMarketTips = "//span[starts-with(normalize-space(), 'Housing Market Tips')]\n";
    private final String discoverToronto = "//li[contains(text(),'Discover Toronto’s Next Hot Neighbourhoods Before ')]";
    private final String sendMailButton = "//button[normalize-space()='Send Mail']";
    private final String sendNow = "//button[normalize-space()='Send Now']";
    private final String invalidLead = "//p[contains(@class,'BatchEmailValidationModal_subMsg__M8SPs')]";
    private final String closeButton = "//button[normalize-space()='Close']";

    // ================================ Send Mail from NOVA AI locators =================================
    private final String mailSubject = "//input[@placeholder='Subject']";
    private final String mailBody = "//div[@aria-label='Editor editing area: main']";
    private final String novaAIButton = "//button[normalize-space()='Nova AI']";
    private final String generateEmail = "//button[normalize-space()='Generate Email']";
    private final String applyEmail = "//button[normalize-space()='Apply Email']";


    // ================================ Add Remove Tags locators =================================
    private final String tags = "//div[@class='selected-people-buttons-container open']//div[1]";
    private final String addTags = "//a[normalize-space()='Add Tags']";
    private final String tagName = "//input[contains(@placeholder,'Search or create a new tag')]";   // Client
    private final String createNewTag = "//*[name()='path' and contains(@d,'M16 8A8 8 ')]";
    private final String selectTagsAdd = "//div[@class='PeopleAddTagModal_item__Roops']//input[@type='checkbox']";
    private final String addTagsButton = "//button[normalize-space()='Add Tags']";

    private final String removeTags = "//a[normalize-space()='Remove Tags']";
    private final String selectRemoveTags = "//div[@class='PeopleRemoveTagModal_item__UeE2J']//input[@type='checkbox']";
    private final String removeTagsButton = "//button[normalize-space()='Remove Tags']";
    private final String alreadySameTagName = "//div[@class='PeopleAddTagModal_item__Roops']";
    private final String noTagFound = "//p[normalize-space()='No tags found.']";
    private final String cancelButton = "//button[@class='Modal_cancelButton__Qftzt me-3']";

    // ================================ More Actions locators =================================
    private final String moreActions = "//div[@class='selected-people-button-panel']//div[2]";
    private final String updateStage = "//a[normalize-space()='Update Stage']";
    private final String hotStage = "//p[normalize-space()='Hot']";
    private final String updateStageButton = "//button[normalize-space()='Update Stage']";
    private final String updateSource = "//a[normalize-space()='Update Source']";
    private final String friendSource = "//p[normalize-space()='Friend']";
    private final String updateSourceButton = "//button[normalize-space()='Update Source']";
    private final String assignAgent = "//a[normalize-space()='Assign Agent']";
    private final String assigneeName = "//span[contains(@class,'name-pills')]";
    private final String assignAgentButton = "//button[normalize-space()='Assign Agent']";


    // ================================ Custom Filter locators =================================
    private final String customFilter = "//a[@id='dropdownMenuLink']";
    private final String chooseFilter = "//select[1]";
    private final String choose = "//select[contains(@class, 'select_filters')]";
    private final String searchData = "//input[@class='form-control rounded-2 border-1 mt-2 border-sky']";
    private final String applyButton = "//button[normalize-space()='Apply']";
    private final String filterCriteria = "//div[contains(@class,'nova-bg-black')]//p";
    private final String filterCount = "div[class='col-md-12 pt-2'] li:nth-child(2)";
    private final String removeFilter = "//*[name()='path' and contains(@d,'M4.646 4.6')]";

    private final String choose1 = "//select[@class='form-control text-size-13 border-sky rounded-2 text-dgray']";
    private final String cancel_Button = "//button[normalize-space()='Cancel']";
    private final String choose2 = "//li[@class='px-3']//select[1]";
    private final String timeAgo = "//input[contains(@class,'form-control rounded-2 border-1 mt-2 border-sky')]";
    private final String lastCommunicationField = "//select[contains(@class,'text-dgray border-sky')]";
    private final String moreThanField = "//select[contains(@class,'text-dgray select_filters')]";
    private final String chooseField = "//li[contains(@class,'px-3')]//select[contains(@class,'text-dgray')]";
    private final String createdField = "//select[contains(@class,'text-dgray border-sky')]";

    // ================================ Import People locators =================================
    private final String importPeople = "//span[normalize-space()='Import People']";
    private final String nextButton = "//button[normalize-space()='Next']";
    private final String emailField = "//tbody/tr[3]/td[4]/div[1]";
    private final String chooseEmailAddress = "//div[contains(text(),'Email Address')]";
    private final String firstNameField = "//tbody/tr[1]/td[4]/div[1]/div[1]/span[1]";
    private final String selectTags = "//span[contains(text(),'Townhomes')]";
    private final String addTagsImport = "//input[@placeholder='Type to add a tag, then press Enter or select from list']";
    private final String submitButton = "//button[normalize-space()='Submit']";
    private final String checkCSVStatus = "//a[contains(text(),'Check CSV Status')]";
    private final String downloadReport = "//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/span[1]/a[1]";


    // ================================= Add & Edit Lead Details Locators =============================================
    private final String select1stLead = "//tbody/tr[2]/td[2]/div[1]";
    private final String callButton = "//button[@type='button'][normalize-space()='Call']";
    private final String closePopup1 = "//div[@class='CallDialerModal_header__HEF_N']//*[name()='svg']";
    private final String closeCall1 = "//button[@class='CallDialerModal_actionButton__Egsjv CallDialerModal_endCallButton__zVxjn false']//span[@class='CallDialerModal_actionIcon__1llnQ']//*[name()='svg']";
    private final String callOn = "//button[@class='CallDialerModal_actionButton__Egsjv CallDialerModal_endCallButton__zVxjn CallDialerModal_pickupCallButton__9lxaF']";

    private final String text = "//button[contains(@class,'btn LeadDetailsPage_textButton__XC5QA false')]";
    private final String textmsg = "//textarea[@placeholder='Message']";
    private final String sendBtn = "//button[normalize-space()='Send']";

    private final String email = "//button[@class='btn LeadDetailsPage_emailButton__mznTx false ']";
    private final String addCC = "//button[normalize-space()='Add CC']";
    private final String addCCAddress = "//input[@placeholder='Enter CC email addresses']";
    private final String addBCC = "//button[normalize-space()='Add BCC']";
    private final String addBCCAddress = "//input[@placeholder='Enter BCC email addresses']";
    private final String addSub = "//input[@placeholder='Subject...']";
    private final String addParagraph = "//div[@aria-label='Editor editing area: main']//p";
    private final String sendEmailBtn = "//button[normalize-space()='Send']";

    // ============================== Add Lead Details ==============================
    private final String addSource = "//aside[contains(@class,'LeadDetailsPage_leftSidebar')]//div[3]//button[1]";
    private final String dropdownContainer = "//div[contains(@class,'ant-select-selector')]";
    private final String sourceType = "//div[@class='ant-select-item-option-content' and text()='Google']";
    private final String saveBtn = "//button[normalize-space()='Save']";
    private final String closePopup = "//*[name()='path' and contains(@d,'M289.94 25')]";
    private final String selectedValue = "//span[@class='ant-select-selection-item']";

    private final String addLead = "//main//div[4]//button[1]//*[name()='svg']";
    private final String leadType = "//div[@class='ant-select-item-option-content' and text()='Seller']";

    private final String addAddress = "//button[normalize-space()='Add Address']";
    private final String alreadyAddAddress = "//span[@class='LeadDetailsPage_addressLabel__LkRJM']";
    private final String enterAddress = "//input[@id='googleSearch']";



    public PeoplePage(TestContextSetup context) {
        this.page = context.page;
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resource/people.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file: " + e.getMessage());
        }
    }

    // ================================ Add new lead method =========================================
    public void navigateToPeoplePage() {
        page.waitForTimeout(6000);
        page.locator(peopleTab).click();
        page.waitForTimeout(10000);
        page.waitForLoadState();
        page.locator("//table//th[normalize-space()='First Name']").waitFor();

        String currentURL = page.url();
        System.out.println("People Page URL: " + currentURL);

        if (!currentURL.contains("/people")) {
            throw new AssertionError(" Not on People page! URL: " + currentURL);
        }
        System.out.println("Confirmed: You are on the People Page!");
    }

    public void clickAddPersonIcon() {
        page.waitForTimeout(2000);
        page.locator(addPersonIcon).click();
    }

    public void createNewLead() {
        page.waitForTimeout(2000);
        page.locator(firstName).fill(prop.getProperty("First_Name"));
        page.locator(lastName).fill(prop.getProperty("Last_Name"));
        page.locator(emailAddress).fill(prop.getProperty("Email_Address"));
        page.selectOption("#country_code", new SelectOption().setLabel("+91"));
        page.locator(phoneNo).fill(prop.getProperty("Phone_Number"));
        page.locator(saveLead).click();
        page.waitForTimeout(2000);

        if (page.locator(duplicateEmailAddress).isVisible()) {
            throw new AssertionError("Duplicate Email Found: " + page.locator(duplicateEmailAddress).innerText());
        }
        if (page.locator(duplicatePhoneNo).isVisible()) {
            throw new AssertionError("Duplicate Phone Found: " + page.locator(duplicatePhoneNo).innerText());
        }
        System.out.println("New lead created successfully.");
    }


    // ================================ Batch Text Methods ================================================
    public void selectLeadAndOpenBatchText() {
        page.waitForTimeout(3000);
        page.locator(selectLead).click();
        page.locator(batchTextIcon).click();
    }

    public void batchTextUseTemplate() {
        page.waitForTimeout(3000);
        page.locator(useTemplate).click();
        page.locator(newBuyersLead).click();
        page.locator(followupReminder).click();
        page.waitForTimeout(2000);
        page.locator(sendButton).click();
        page.waitForTimeout(2000);
        System.out.println("Text sent successfully using " + "from Template");
    }

    public void backPage() {
        page.waitForTimeout(5000);
        page.locator(backButton).click();
    }

    public void batchTextCreateTemplate() {
        // Reuse common step
        selectLeadAndOpenBatchText();
        page.waitForTimeout(2000);
        page.locator(templateName).fill("New Property: Coming Soon");
        page.locator(messageBody).fill("Canada, Toronto Condos Property");
        page.waitForTimeout(2000);
        page.locator(sendButton).click();
        backPage();
        System.out.println("Text sent successfully from " + "Create Text Template");
    }


    // ================================ Send Mail Methods ================================================
    public void selectLeadAndOpenMail() {
        page.waitForTimeout(3000);
        page.locator(selectLead).click();
        page.locator(sendMail).click();
    }

    public void sendMailUseTemplate() {
        page.waitForTimeout(3000);
        page.locator(useTemplateMail).click();
        page.locator(housingMarketTips).click();
        page.waitForTimeout(4000);
        page.locator(discoverToronto).click();
        page.waitForTimeout(2000);
        page.locator(sendMailButton).click();
        handleValidOrInvalidLead("Use Template");
    }

    public void backPageEmailMarketing() {
        page.waitForTimeout(5000);
        page.locator(peopleTab).click();
        page.waitForTimeout(4000);
    }

    public void sendMailNOVA_AI() {
        selectLeadAndOpenMail();
        page.waitForTimeout(2000);
        page.locator(mailSubject).fill("Brampton Property Deal");
        page.waitForTimeout(1000);
        page.locator(mailBody).fill("New Brampton Condos Property Discussion");
        page.locator(novaAIButton).click();
        page.waitForTimeout(3000);
        page.locator(generateEmail).click();
        page.locator(applyEmail).click();
        page.waitForTimeout(2000);
        page.locator(sendMailButton).click();
        handleValidOrInvalidLead("NOVA AI");
    }

    private void handleValidOrInvalidLead(String mailType) {
        try {
            // Try to wait for Send Now button for up to 5 seconds
            page.locator(sendNow).waitFor(new Locator.WaitForOptions().setTimeout(5000));
            page.locator(sendNow).click();
            System.out.println("Send Mail successfully from " + mailType);
        } catch (PlaywrightException e) {
            // If Send Now did NOT appear in time — treat as invalid lead
            String invalidLeadText = page.locator(invalidLead).innerText();
            page.locator(closeButton).click();
            throw new AssertionError(
                    "You don't have any valid lead, please wait till we can validate your leads.\n\n"
                            + invalidLeadText
            );
        }
    }

    // ================================ Tag Methods ================================================
    public void selectLeadAndClickTag() {
        page.waitForTimeout(3000);
        page.locator(selectLead).click();
        page.locator(tags).click();
        System.out.println("Successfully clicked Tag icon at the bottom.");
    }

    public void selectLeadAndAddTag() {
        page.waitForTimeout(3000);
        page.locator(addTags).click();
        page.waitForTimeout(2000);
        page.locator(tagName).fill("Insta");
        page.waitForTimeout(3000);

        // Check if tag already exists
        boolean isTagAlreadyCreated = page.locator(alreadySameTagName).isVisible();
        if (isTagAlreadyCreated) {
            System.out.println("Tag already exists.");
            page.waitForTimeout(2000);
            page.locator(selectTagsAdd).click();
            page.waitForTimeout(1000);
            page.locator(addTagsButton).click();
        } else {
            System.out.println("Tag does not exist.");
            page.waitForTimeout(2000);
            page.locator(createNewTag).click();
            page.locator(selectTagsAdd).click();
            page.locator(addTagsButton).click();
            System.out.println("New Tag Add Successfully");
        }
    }

    public void selectLeadAndRemoveTag() {
        // {
        selectLeadAndClickTag();
        page.locator(removeTags).click();
        page.locator(tagName).fill("Insta");
        page.waitForTimeout(3000);
        //} catch (Exception e) {

        boolean isValidTag = page.locator(selectRemoveTags).isVisible();
        if (isValidTag) {
            page.waitForTimeout(1000);
            page.locator(selectRemoveTags).click();
            page.waitForTimeout(2000);
            page.locator(removeTagsButton).click();
            page.waitForTimeout(2000);
            System.out.println("Remove Tag Successfully !!!");
        } else {
            String noTag = page.locator(noTagFound).innerText();
            page.waitForTimeout(2000);
            page.locator(cancelButton).click();
            throw new AssertionError(
                    "You don't have any valid tag to remove.\n\n" + noTag
            );
        }
    }

    // ================================ More Actions Methods ================================================
    public void selectLeadAndClickMoreActions() {
        page.waitForTimeout(3000);
        page.locator(selectLead).click();
        page.locator(moreActions).click();
    }

    public void setUpdateStage() {
        page.waitForTimeout(3000);
        page.locator(updateStage).click();
        page.waitForTimeout(2000);
        page.locator(hotStage).click();
        page.waitForTimeout(2000);
        page.locator(updateStageButton).click();
        System.out.println("Stage Update Successfully");
    }

    public void setUpdateSource() {
        selectLeadAndClickMoreActions();
        page.locator(updateSource).click();
        page.waitForTimeout(2000);
        page.locator(friendSource).click();
        page.waitForTimeout(2000);
        page.locator(updateSourceButton).click();
        System.out.println("Source Update Successfully");
    }

    public void setAssignAgent() {
        page.waitForTimeout(3000);
        selectLeadAndClickMoreActions();
        page.locator(assignAgent).click();
        page.waitForTimeout(2000);
        page.locator(assigneeName).click();
        page.waitForTimeout(2000);
        page.locator(assignAgentButton).click();
        System.out.println("Assign Agent Successfully");
    }

    // ================================ Custom Filter Methods =====================================
    public void applyFilter(String fieldName, String filterType, String searchText) {
        page.waitForTimeout(2000);
        page.locator(customFilter).click();
        page.waitForTimeout(2000);
        page.locator(chooseFilter).selectOption(new SelectOption().setValue(fieldName));
        page.waitForTimeout(2000);
        page.locator(choose).selectOption(new SelectOption().setValue(filterType));

        if (searchText != null && !searchText.isEmpty()) {
            page.locator(searchData).fill(searchText);
        }

        page.waitForTimeout(2000);
        page.locator(applyButton).click();
        page.waitForTimeout(3000);
        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();
        page.waitForTimeout(2000);
        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        System.out.println("Applied Filter: " + criteria + " " + count);
    }

    // ================================ Specific Filter Calls =====================================
    public void selectFirstName_startwith() {
        applyFilter("first_name", "start_with", "A");
    }
    public void selectFirstName_isempty() {
        applyFilter("first_name", "is_empty", null);
    }
    public void selectFirstName_contain() {
        applyFilter("first_name", "contains", "Adi");
        System.out.println("First Name Filter verify successfully");
    }

    public void selectLastName_startwith() {
        applyFilter("last_name", "start_with", "C");
    }
    public void selectLastName_isempty() {
        applyFilter("last_name", "is_empty", null);
    }
    public void selectLastName_contain() {
        applyFilter("last_name", "contains", "P");
        System.out.println("Last Name Filter verify successfully");
    }

    public void selectEmail_startwith() {
        applyFilter("email", "start_with", "adi");
    }
    public void selectEmail_isempty() {
        applyFilter("email", "is_empty", null);
    }
    public void selectEmail_contain() {
        applyFilter("email", "contains", "mmnovatech");
        System.out.println("Email Filter verify successfully");
    }

    public void selectPhone_startwith() {
        applyFilter("phone", "start_with", "79");
    }
    public void selectPhone_isempty() {
        applyFilter("phone", "is_empty", null);
    }
    public void selectPhone_contain() {
        applyFilter("phone", "contains", "1234");
        System.out.println("Phone Filter verify successfully");
    }


    // ========================== Reusable Filter Utilities ===============================
    private void openCustomFilter(String field, String operation) {
        page.waitForTimeout(2000);
        page.locator(customFilter).click();
        page.waitForTimeout(2000);
        page.locator(chooseFilter).selectOption(new SelectOption().setValue(field));
        page.waitForTimeout(2000);
        page.locator(choose).selectOption(new SelectOption().setValue(operation));
        page.waitForTimeout(2000);
    }

    private void applyAndPrintResultGeneric() {
        page.locator(applyButton).click();
        page.waitForTimeout(3000);
        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();
        page.waitForTimeout(2000);
        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        System.out.println("Applied Filter: " + criteria + " " + count);
    }

    private void applyFilterIfOptionAvailable(String valueToSelect, String fieldName) {
        Locator optionsLocator = page.locator("select.form-control.text-size-13.border-sky.rounded-2.text-dgray >> option");
        List<String> options = optionsLocator.allTextContents();

        if (options.stream().anyMatch(tag -> tag.trim().equalsIgnoreCase(valueToSelect))) {
            Locator allDropdowns = page.locator("select.form-control.text-size-13.border-sky.rounded-2.text-dgray");
            int dropdownCount = allDropdowns.count();
            allDropdowns.nth(dropdownCount - 1)
                    .selectOption(new SelectOption().setLabel(valueToSelect));
            page.waitForTimeout(2000);
            System.out.println(fieldName + " applied successfully: " + valueToSelect);
            applyAndPrintResultGeneric();
        } else {
            page.locator(cancel_Button).click();
            System.out.println(fieldName + " not available: " + valueToSelect);
        }
    }

    // ========================== Stage Filters ===============================
    public void selectStage_include() {
        openCustomFilter("stage", "include");
        page.locator(choose1).selectOption(new SelectOption().setValue("Hot"));
        page.waitForTimeout(2000);
        applyAndPrintResultGeneric();
    }

    public void selectStage_exclude() {
        openCustomFilter("stage", "exclude");
        page.locator(choose1).selectOption(new SelectOption().setValue("Hot"));
        page.waitForTimeout(2000);
        applyAndPrintResultGeneric();
    }

    public void selectStage_is_empty() {
        openCustomFilter("stage", "is_empty");
        applyAndPrintResultGeneric();
    }

    public void selectStage_is_not_empty() {
        openCustomFilter("stage", "is_not_empty");
        applyAndPrintResultGeneric();
        System.out.println("Stages Filter verify successfully");
    }

    // ========================== Tags Filters ===============================
    public void selectTags_include() {
        openCustomFilter("tags", "include");
        applyFilterIfOptionAvailable("ABCD", "Tag");
    }

    public void selectTags_exclude() {
        openCustomFilter("tags", "exclude");
        applyFilterIfOptionAvailable("1234", "Tag");
    }

    public void selectTags_is_empty() {
        openCustomFilter("tags", "is_empty");
        applyAndPrintResultGeneric();
    }

    public void selectTags_is_not_empty() {
        openCustomFilter("tags", "is_not_empty");
        applyAndPrintResultGeneric();
        System.out.println("Tags Filter verify successfully");
    }

    // ========================== Source Filters ===============================
    public void selectSource_include() {
        openCustomFilter("source", "include");
        applyFilterIfOptionAvailable("Google1", "Source");
    }

    public void selectSource_exclude() {
        openCustomFilter("source", "exclude");
        applyFilterIfOptionAvailable("Google", "Source");
    }

    public void selectSource_is_empty() {
        openCustomFilter("source", "is_empty");
        applyAndPrintResultGeneric();
    }

    public void selectSource_is_not_empty() {
        openCustomFilter("source", "is_not_empty");
        applyAndPrintResultGeneric();
        System.out.println("Source Filter verify successfully");
    }

    // ========================== Lead Type Filters ===============================
    public void selectLead_Type_include() {
        openCustomFilter("lead_type", "include");
        applyFilterIfOptionAvailable("Buyer", "Lead Type");
    }

    public void selectLead_Type_exclude() {
        openCustomFilter("lead_type", "exclude");
        applyFilterIfOptionAvailable("Agent", "Lead Type");
    }

    public void selectLead_Type_is_empty() {
        openCustomFilter("lead_type", "is_empty");
        applyAndPrintResultGeneric();
    }

    public void selectLead_Type_is_not_empty() {
        openCustomFilter("lead_type", "is_not_empty");
        applyAndPrintResultGeneric();
        System.out.println("Select Lead Filter verify successfully");
    }

    // =========================================== Last Communication ==============================================
    public void selectInclude() {
        page.waitForTimeout(2000);
        page.locator(customFilter).click();
        page.waitForTimeout(2000);
        page.locator(chooseFilter).selectOption(new SelectOption().setValue("last_communication"));
        page.waitForTimeout(2000);
        page.locator(choose).selectOption(new SelectOption().setValue("include"));
        page.waitForTimeout(2000);
        page.locator(choose1).selectOption(new SelectOption().setLabel("Email"));
        page.waitForTimeout(2000);
        page.locator(applyButton).click();
        page.waitForTimeout(3000);

        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();

        page.waitForTimeout(2000);
        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        System.out.println("Applied Filter: " + criteria + " " + count);
    }

    public void selectExclude() {
        page.waitForTimeout(2000);
        page.locator(customFilter).click();
        page.waitForTimeout(2000);
        page.locator(chooseFilter).selectOption(new SelectOption().setValue("last_communication"));
        page.waitForTimeout(2000);
        page.locator(choose).selectOption(new SelectOption().setValue("exclude"));
        page.waitForTimeout(2000);
        page.locator(choose1).selectOption(new SelectOption().setLabel("Email"));
        page.waitForTimeout(2000);
        page.locator(applyButton).click();
        page.waitForTimeout(3000);

        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();

        page.waitForTimeout(2000);
        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        System.out.println("Applied Filter: " + criteria + " " + count);
    }

    public void select_is_empty() {
        page.waitForTimeout(2000);
        page.locator(customFilter).click();
        page.waitForTimeout(2000);
        page.locator(chooseFilter).selectOption(new SelectOption().setValue("last_communication"));
        page.waitForTimeout(2000);
        page.locator(choose).selectOption(new SelectOption().setValue("is_empty"));
        page.waitForTimeout(2000);
        page.locator(applyButton).click();
        page.waitForTimeout(3000);

        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();
        page.waitForTimeout(2000);
        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        System.out.println("Applied Filter: " + criteria + " " + count);
    }

    public void select_is_not_empty() {
        page.waitForTimeout(2000);
        page.locator(customFilter).click();
        page.waitForTimeout(2000);
        page.locator(chooseFilter).selectOption(new SelectOption().setValue("last_communication"));
        page.waitForTimeout(2000);
        page.locator(choose).selectOption(new SelectOption().setValue("is_empty"));
        page.waitForTimeout(2000);
        page.locator(applyButton).click();
        page.waitForTimeout(3000);

        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();
        page.waitForTimeout(2000);
        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        System.out.println("Applied Filter: " + criteria + " " + count);
    }

    // ============================================ Last Communication less/more than =============================================
    // Extract common time filters
    private Map<String, String> getTimeFilters() {
        Map<String, String> timeFilters = new LinkedHashMap<>();
        timeFilters.put("minute", "10");
        timeFilters.put("hour", "4");
        timeFilters.put("day", "5");
        timeFilters.put("week", "2");
        timeFilters.put("month", "3");
        timeFilters.put("year", "1");
        return timeFilters;
    }

    // Extract filter setup
    private void setupFilter(String fieldLocator, String typeLocator, String fieldValue, String typeValue) {
        page.waitForTimeout(3000);
        page.locator(customFilter).click();
        page.waitForSelector(fieldLocator).isVisible();
        page.locator(fieldLocator).selectOption(new SelectOption().setValue(fieldValue));
        page.waitForSelector(typeLocator).isVisible();
        page.locator(typeLocator).selectOption(new SelectOption().setValue(typeValue));
        page.waitForTimeout(2000);
    }

    // Extract apply + verify + remove + re-setup logic
    private void applyAndVerifyFilter(String unit, String value, String unitDropdown, String fieldLocator, String typeLocator, String fieldValue, String typeValue) {
        page.locator(unitDropdown).selectOption(new SelectOption().setValue(unit));
        page.waitForTimeout(1000);
        page.locator(timeAgo).fill(value);
        page.waitForTimeout(2000);
        page.locator(applyButton).click();
        page.waitForTimeout(2000);

        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();
        System.out.println("Applied Filter - Unit: " + unit + ", Value: " + value + " => " + criteria + " " + count);

        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        setupFilter(fieldLocator, typeLocator, fieldValue, typeValue);
    }

    // LESS THAN
    public void select_less_than() {
        page.waitForTimeout(2000);
        setupFilter(chooseFilter, choose, "last_communication", "less_then");

        for (Map.Entry<String, String> entry : getTimeFilters().entrySet()) {
            applyAndVerifyFilter(
                    entry.getKey(), entry.getValue(),
                    choose2, chooseFilter, choose, "last_communication", "less_then"
            );
        }
    }

    // MORE THAN
    public void select_more_than() {
        page.reload();
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForTimeout(10000);
        setupFilter(lastCommunicationField, moreThanField, "last_communication", "more_than");

        for (Map.Entry<String, String> entry : getTimeFilters().entrySet()) {
            applyAndVerifyFilter(
                    entry.getKey(), entry.getValue(),
                    chooseField, lastCommunicationField, moreThanField, "last_communication", "more_than"
            );
        }
    }

    // ========================================== Created Method less/more than =================================================
    private Map<String, String> buildTimeFilterData() {
        Map<String, String> filters = new LinkedHashMap<>();
        filters.put("minute", "10");
        filters.put("hour", "4");
        filters.put("day", "5");
        filters.put("week", "2");
        filters.put("month", "3");
        filters.put("year", "1");
        return filters;
    }

    private void prepareFilterDropdowns(String fieldLocator, String typeLocator, String fieldValue, String typeValue) {
        page.waitForTimeout(3000);
        page.locator(customFilter).click();
        page.waitForSelector(fieldLocator).isVisible();
        page.locator(fieldLocator).selectOption(new SelectOption().setValue(fieldValue));
        page.waitForSelector(typeLocator).isVisible();
        page.locator(typeLocator).selectOption(new SelectOption().setValue(typeValue));
        page.waitForTimeout(2000);
    }

    private void applyFilterAndLogResults(String unitDropdown, String unit, String value,
                                          String fieldLocator, String typeLocator,
                                          String fieldValue, String typeValue) {

        page.locator(unitDropdown).selectOption(new SelectOption().setValue(unit));
        page.waitForTimeout(1000);
        page.locator(timeAgo).fill(value);
        page.waitForTimeout(2000);
        page.locator(applyButton).click();
        page.waitForTimeout(2000);

        String criteria = page.locator(filterCriteria).innerText().replace("\n", " ").trim();
        String count = page.locator(filterCount).innerText().trim();
        System.out.println("Applied Filter - Unit: " + unit + ", Value: " + value + " => " + criteria + " " + count);

        page.locator(removeFilter).click();
        page.waitForTimeout(2000);
        prepareFilterDropdowns(fieldLocator, typeLocator, fieldValue, typeValue);
    }

    public void applyCreatedLessThanFilter() {
        page.waitForTimeout(2000);
        prepareFilterDropdowns(createdField, moreThanField, "created", "less_then");

        for (Map.Entry<String, String> entry : buildTimeFilterData().entrySet()) {
            applyFilterAndLogResults(chooseField, entry.getKey(), entry.getValue(), createdField, moreThanField, "created", "less_then");
        }
    }

    public void applyCreatedMoreThanFilter() {
        page.reload();
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForTimeout(10000);
        prepareFilterDropdowns(createdField, moreThanField, "created", "more_than");

        for (Map.Entry<String, String> entry : buildTimeFilterData().entrySet()) {
            applyFilterAndLogResults(chooseField, entry.getKey(), entry.getValue(), createdField, moreThanField, "created", "more_than");
        }
    }


    // ====================================== Import People ===============================================
    public void importpeople() {
        page.locator(importPeople).click();
        page.waitForTimeout(2000);
        String fileName = "Test Lead.csv";
        String filePath = System.getProperty("user.home") + "/Downloads/" + fileName;
        page.setInputFiles("input[type='file']", Paths.get(filePath));
        page.waitForTimeout(2000);
        page.locator(nextButton).click();
        page.waitForTimeout(2000);
        System.out.println("File uploaded successfully!");
    }

    public void fillMandatoryField() {
        page.locator(nextButton).click();
        page.waitForTimeout(3000);
        // Check if we are still on the same page (i.e., form didn’t proceed)
        boolean isNextStillVisible = page.locator(nextButton).isVisible();

        if (isNextStillVisible) {
            System.out.println("Mandatory fields are not filled. Now filling Email and First Name...");

            // Fill the Email field
            page.locator(emailField).click();
            page.locator(chooseEmailAddress).click();
            page.waitForTimeout(3000);
            System.out.println("Email field filled.");

            // Fill the First Name field
            page.locator(firstNameField).click();
            page.waitForTimeout(1000);
            page.locator("//div[@class='ant-select-item-option-content'][normalize-space()='First Name']").nth(1).click();
            page.waitForTimeout(2000);
            System.out.println("First Name field filled.");

            // Retry clicking Next
            page.locator(nextButton).click();
            page.waitForTimeout(3000);
            System.out.println("Proceeded to the next step after filling mandatory fields.");
        } else {
            System.out.println("Email and First Name fields were already filled. Proceeded successfully.");
        }
    }

    public void tagsField() {
        page.locator(selectTags).click();
        page.waitForTimeout(2000);
        Locator tagInput = page.locator(addTagsImport);
        tagInput.fill("Zoom");
        tagInput.press("Enter");
        System.out.println("Tag added successfully.");
    }

    public void submit() {
        page.locator(submitButton).click();
        page.waitForTimeout(6000);
        System.out.println("Lead Imported Successfully");
    }

    public void openCheckCsvStatus() {
        Locator importPeopleButton = page.locator(importPeople);
        importPeopleButton.hover();
        page.waitForTimeout(2000); // allow dropdown to load
        page.locator(checkCSVStatus).click();
        page.waitForTimeout(2000);
        page.locator(downloadReport).click();
    }


    // ====================================== Add & Edit Lead Details ===============================================
    public void selectLead() {
        page.locator(select1stLead).click();
        page.waitForTimeout(3000);
        System.out.println("Select Lead Successfully");
    }

    public void leadCall() {
        // Grant microphone permission
        page.context().grantPermissions(
                Arrays.asList("microphone"),
                new BrowserContext.GrantPermissionsOptions().setOrigin("https://app.novacrm.ca")
        );

        // Click the main call button
        page.locator(callButton).click();
        Locator callBtn = page.locator(callOn);

        // Wait for the call button to appear (if any)
        callBtn.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000)
        );

        // Check if the call button is visible and enabled
        if (callBtn.isVisible()) {
            callBtn.click();
            System.out.println("Valid mobile number, call initiated");
            page.waitForTimeout(8000);
            page.locator(closeCall1).click();
        } else {
            page.locator(closeCall1).click();
            System.out.println("Invalid mobile number, call not initiated");
        }

        // Wait and close final popup
        page.waitForTimeout(3000);
        page.locator(closePopup1).click();
    }


    public void sendTextMessage() {
        page.waitForTimeout(5000);
        page.locator(text).click();
        page.waitForTimeout(3000);
        page.locator(textmsg).fill("Hello User,\n" +
                "Please follow the steps, to open your NOVA Account");
        page.waitForTimeout(1000);
        page.locator(sendBtn).click();
        page.waitForTimeout(1000);
        System.out.println("Msg send successfully to the lead");

    }

    public void sendEmail() {
        page.waitForTimeout(4000);
        page.locator(email).click();
        page.waitForTimeout(3000);
        page.locator(addCC).click();
        page.locator(addCCAddress).fill("adish@mmnovatech.com");
        page.waitForTimeout(2000);
        page.locator(addBCC).click();
        page.locator(addBCCAddress).fill("vijay+12@mmnovatech.com");
        page.waitForTimeout(2000);
        page.locator(addSub).fill("Real Estate Property");
        page.waitForTimeout(2000);
        page.locator(addParagraph).fill("Canada, Torronto Condos Property");
        page.waitForTimeout(2000);
        page.locator(sendEmailBtn).click();
        page.waitForTimeout(2000);
        System.out.println("Email send successfully to the lead");
    }

    public void addLeadDetails() {
        // ========================= Add Source ===================================
        page.locator(addSource).click();
        page.locator(dropdownContainer).click();
        page.waitForTimeout(2000);
        String currentSource = "";
        Locator selected = page.locator(selectedValue);
        if (selected.isVisible()) {
            currentSource = selected.innerText().trim();
        }
        if (currentSource.equals("Google")) {
            page.locator(closePopup).click();
            System.out.println("Lead source already selected");

        } else {
            page.locator(sourceType).click();
            page.locator(saveBtn).click();
            page.waitForTimeout(2000);
            System.out.println("Lead source selected successfully");
        }
    }

    }

