package pageObject;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import utils.TestContextSetup;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;


public class HomePage {
    private final Page page;
    private final Properties prop;

    //================================== Home Page Search Locator ====================================
    private final String search = "[placeholder='Search']";
    private final String clickLeadName = "(//ul[@class='top-search']//li)[1]";
    private final String checkLeadName = "//h2[contains(@class, 'LeadDetailsPage_profileName')]";

    //================================== Home Page Notification Locator ====================================
    private final String notificationCount = "//div[@class='ant-popover-title']";
    private final String notificationIconClick = "//a[contains(@class, 'btn pt-1 pb-1')]//*[name()='svg' and contains(@class, 'size-22')]";

    //================================== Home Page Add New Lead Locator ====================================
    private final String addAPerson = "//button[@class='btn nova-bg-sky bottom-header-icon ']";
    private final String firstName = "//input[@placeholder='First name *']";
    private final String lastName = "//input[contains(@placeholder,'Last name')]";
    private final String emailAddress = "//input[@placeholder='Email Address *']";
    private final String duplicateEmailAddress = "//span[normalize-space()='The email address has already been taken.']";
    private final String countryCode = "//select[@id='country_code']";
    private final String phoneNo = "//input[@placeholder='Phone No. *']";
    private final String duplicatePhoneNo = "//span[normalize-space()='The contact number has already been taken.']";
    private final String saveLead = "//button[normalize-space()='Save Lead']";

    //================================== Home Page Send a text Locator ====================================
    private final String addTextIcon = "//button[3]//*[name()='svg']";
    private final String enterName = "//input[@placeholder='Enter name or phone number']";     //Raghav 1st
    private final String roleButton = "//li[@role='button']";
    private final String writeText = "//textarea[@placeholder='Write your text']";        // Hii, How Are You
    private final String sendMessage = "//button[normalize-space()='Send Message']";
    private final String ndf = "//b[normalize-space()='No Data Found']";

    //================================== Home Page Send Email Locators ====================================
    private final String sendEmailIcon = "//div[@class='header-wrapper ']//button[2]";
    private final String toReceiptantName = "//div[@class='ant-select-selection-overflow']";
    private final String selectReceiptant = "//input[contains(@class,'ant-select-selection-search-input')]";
    private final String subject = "//input[@class='form-control border-0 text-size-14']";
    private final String body = "//textarea[@class='form-control text-size-14']";
    private final String sendEmailNowButton = "//button[normalize-space()='Send Email Now']";
    private final String noEmailFound = "//div[@class='ant-empty-description']";

    //================================ Home Page Make a Call Locators =====================================
    private final String makeACallIcon = "//div[@class='col-lg-3']//button[1]";
    private final String enterNameOrPhone = "//input[@placeholder='Enter name or phone number']";
    private final String firstUser = "//li[@role='button']";
    private final String callButton = "//button[@class='CallDialerModal_actionButton__Egsjv CallDialerModal_endCallButton__zVxjn CallDialerModal_pickupCallButton__9lxaF']";
    private final String noDataFound = "//b[normalize-space()='No Data Found']";
    private final String closePopup = "//div[@class='CallDialerModal_header__HEF_N']//*[name()='svg']";
    private final String closeCall = "//button[@class='CallDialerModal_actionButton__Egsjv CallDialerModal_endCallButton__zVxjn false']//span[@class='CallDialerModal_actionIcon__1llnQ']//*[name()='svg']";

    //==================================== Pages Redirection Locators =========================================
    private final String home = "//span[normalize-space()='Home']";
    private final String people = "//span[normalize-space()='People']";
    private final String inbox = "//span[normalize-space()='Inbox']";
    private final String emailMarketing = "//span[normalize-space()='Email Marketing']";
    private final String socialMediaManagement = "//span[normalize-space()='Social Media Management']";
    private final String tasks = "//a[@href='/task']//span[contains(text(),'Tasks')]";
    private final String deals = "//span[normalize-space()='Deals']";

    //==================================== Boxes Locators =========================================
    private final String availableCredit = "//span[normalize-space()='Available Credit']";
    private final String creditBalance = "(//span[@class='Homepage_value__aE6TT']) [1]";
    private final String creditHistory = "//a[normalize-space()='View History']";

    private final String newLeads = "//span[normalize-space()='New Leads']";
    private final String totalNewLeads = "(//span[@class='Homepage_value__aE6TT']) [2]";
    private final String newLeadsViewAll = "//a[contains(@href,'/people?new_leads=true')][normalize-space()='View All']";

    private final String todayTask = "//a[@href='/task']//div[@class='Homepage_cardDetail__BSW_1']//div[@class='Homepage_header__WJvbS']//span[@class='Homepage_title__MC5i2']";
    private final String todayTaskCount = "(//span[@class='Homepage_value__aE6TT']) [3]";
    private final String todayTaskViewAll = "//a[contains(@href,'/task')][normalize-space()='View All']";

    private final String incompleteFollowUps = "//span[normalize-space()='Incomplete Follow Ups']";
    private final String incompleteFollowUpsCount = "(//span[@class='Homepage_value__aE6TT']) [4]";
    private final String incompleteFollowUpsViewAll = "//a[contains(@href,'/people?incomplete_follow_up=true')][normalize-space()='View All']";

    //================================= Email Marketing Locators ==========================================
    private final String clickFilter = "//div[@class='Homepage_emailMarketingContainer__ocQ4K']//select";
    private final String viewMore = "//a[@href='/email-marketing'][normalize-space()='View More']";

    //==================================== Tasks Locators ==============================================
    private final String appointmentCheckbox = "//label[contains(.,'Appointments')]";
    private final String emailSchedulesCheckbox = "//label[contains(.,'Email Schedules')]";
    private final String taskCheckbox = "//label[contains(.,'Tasks')]";
    private final String socialMediaSchedulesCheckbox = "//label[contains(.,'Social Media Schedules')]";
    private final String viewMoreCheckbox = "//a[@class='CalendarToolbar_viewMore__Ty2w_']";

    //======================================= Automation Locators ===========================================
    private final String automationViewAll = "//a[normalize-space()='View All Automation']";

    //==================================== Social Media Locators ==============================================
    private final String socialMediaDropdown = "//a[@class='ant-dropdown-trigger']";
    private final String selectFacebook = "//div[@class='ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomLeft ']//li[1]";
    private final String socialMediaFilter = "//div[@class='Homepage_socialMediaContainer___aX8q']//select";
    private final String selectInstagram = "//div[@class='ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomLeft ']//li[2]";
    private final String viewMoreSocialMedia = "//a[@href='/social-media'][normalize-space()='View More']";


    public HomePage(TestContextSetup context) {
        this.page = context.page;
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resource/global.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file: " + e.getMessage());
        }
    }

    //=============================== Home Page Search Method ========================================
    public void validateSearchFunctionality() {

        try {
            page.waitForTimeout(4000);
            page.waitForSelector("p.Homepage_name__4nOLC");

            String searchData = prop.getProperty("SearchData");
            page.locator(search).fill(searchData);
            page.waitForTimeout(3000);

            // Check if any search suggestions exist
            Locator results = page.locator("ul.top-search li");
            int count = results.count();

            if (count > 0) {
                // Click first item from results
                page.locator(clickLeadName).click();
                page.waitForSelector(checkLeadName); // Wait for name to be visible
                String actualLeadName = page.locator(checkLeadName).innerText();
                System.out.println("Lead Name from Details Page: " + actualLeadName);

            } else {
                System.out.println("No search results found");
            }

        } catch (Exception e) {
            System.out.println("Search operation failed: " + e.getMessage());
        }
    }

    //================================== Home Page Notification Method ====================================
    public void notificationIcon() {
        try {
            page.waitForTimeout(2000);
            Locator notify = page.locator(notificationIconClick);
            notify.waitFor();  // wait until icon is attached
            notify.click();    // click to open notification panel
            page.locator(notificationCount).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            page.waitForTimeout(4000); // slight delay for content to load
            System.out.println("Notification modal page opened successfully");
        } catch (Exception e) {
            System.out.println("Failed to open notification modal: " + e.getMessage());
        }
    }

    public void notificationCountMsg() {
        try {
            page.waitForTimeout(2000);
            Locator notify = page.locator(notificationCount);
            if (notify.isVisible()) {
                String text = notify.innerText().trim();  // Ex: "Notifications (5)"
                String countOnly = text.replaceAll("[^0-9]", ""); // Extracts 5
                System.out.println("Notification Count:- Notification (" + countOnly + ")");
            } else {
                System.out.println("Notification Count:- Notification 0");
            }
        } catch (Exception e) {
            System.out.println("Notification Count:- Notification 0");
        }
    }


    //================================== Home Page Add New Lead Method ====================================
    public void addNewLead() {
        page.waitForTimeout(5000);
        page.locator(addAPerson).click();
        String first_Name = prop.getProperty("FirstName");
        page.locator(firstName).fill(first_Name);
        String last_Name = prop.getProperty("LastName");
        page.locator(lastName).fill(last_Name);
        String email_Address = prop.getProperty("EmailAddress");
        page.locator(emailAddress).fill(email_Address);
        page.waitForTimeout(2000);
        page.locator(countryCode).click();
        page.selectOption("#country_code", new SelectOption().setLabel("+91"));
        String phoneNumber = prop.getProperty("PhoneNumber");
        page.locator(phoneNo).fill(phoneNumber);
        page.locator(saveLead).click();
        page.waitForTimeout(3000); // wait for error to appear
        boolean isDuplicateEmail = page.locator(duplicateEmailAddress).isVisible();
        boolean isDuplicatePhone = page.locator(duplicatePhoneNo).isVisible();

        if (isDuplicateEmail) {
            String duplicateEmail = page.locator(duplicateEmailAddress).innerText();
            throw new AssertionError("Test Failed: Duplicate Email Detected - " + duplicateEmail);
        }

        if (isDuplicatePhone) {
            String duplicatePhone = page.locator(duplicatePhoneNo).innerText();
            throw new AssertionError("Test Failed: Duplicate Phone Detected - " + duplicatePhone);
        }
        System.out.println("Add new lead successfully");
    }

    //================================== Home Page Send a text Method ====================================
    public void sendTextIcon() {
        page.waitForTimeout(6000);
        page.locator(addTextIcon).click();
    }

    public boolean enterName() {
        page.waitForTimeout(2000);
        String searchName = prop.getProperty("SearchName");
        page.locator(enterName).fill(searchName);

        page.waitForTimeout(2000);
        Locator results = page.locator("//li[@role='button']");
        int count = results.count();

        if (count > 0) {
            System.out.println("Search result count: " + count);
            results.nth(0).click();
            Locator messageInput = page.locator(writeText);
            messageInput.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(2000)
            );

            String sendMsg = prop.getProperty("SendMessage");
            messageInput.fill(sendMsg);
            return true;

        } else {
            String noValidData = page.locator(ndf).innerText();
            System.out.println("No valid search data found: " + noValidData);
            return false;
        }
    }

    public void sendMessageButton() {
        try {
            page.locator(sendMessage).click();
            System.out.println("Send a Text to user successfully");
        } catch (Exception e) {
            System.out.println("Failed to click Send Message button: " + e.getMessage());
        }
    }

    //================================== Home Page Send Email Method ====================================
    public boolean clickSendEmailIcon(String email) {
        page.waitForTimeout(4000);

        // Click the Send Email icon
        page.locator(sendEmailIcon).click();
        page.waitForTimeout(2000);

        // Click the To field to activate it
        page.locator(toReceiptantName).click();
        Locator input = page.locator(selectReceiptant);

        // Fill the email slowly to trigger suggestions
        input.fill("");
        input.type(email, new Locator.TypeOptions().setDelay(200)); // type with delay

        // Locator for the dropdown option
        Locator resultOption = page.locator(
                "//div[contains(@class,'ant-select-item-option-content') and contains(text(),'" + email + "')]"
        );

        // Wait for the dropdown option to appear and click it
        try {
            resultOption.waitFor(new Locator.WaitForOptions().setTimeout(5000).setState(WaitForSelectorState.VISIBLE));
            resultOption.click();
            System.out.println("Recipient selected: " + email);
            return true;
        } catch (Exception e) {
            if (page.locator(noEmailFound).isVisible()) {
                String noValidData = page.locator(noEmailFound).innerText();
                System.out.println("No valid search email found: " + noValidData);
            } else {
                System.out.println("Recipient dropdown option did not appear for: " + email);
            }
            return false;
        }
    }

    public void receiptantName() {
        page.waitForTimeout(2000);
        String mailSubject = prop.getProperty("MailSubject");
        page.locator(subject).fill(mailSubject);
    }

    public void clickEmailNowButton() {
        page.waitForTimeout(2000);
        String mailBody = prop.getProperty("MailBody");
        page.locator(body).fill(mailBody);
        page.locator(sendEmailNowButton).click();
        System.out.println("Email sent successfully.");
    }

    //================================== Home Page Make a Call Method ====================================
    public void makeCallIcon() {
        page.context().grantPermissions(
                Arrays.asList("microphone"),
                new BrowserContext.GrantPermissionsOptions().setOrigin("https://app.novacrm.ca")
        );

        page.waitForTimeout(4000);
        page.locator(makeACallIcon).click();
    }

    public boolean enterNameOrPhone() {
        page.waitForTimeout(2000);
        page.locator(enterNameOrPhone).fill("Vijay");
        page.waitForTimeout(3000);
        Locator results = page.locator("//li[@role='button']");
        int count = results.count();

        if (count > 0) {
            System.out.println("Search result count: " + count);

            // Click first result
            results.nth(0).click();

            // Wait for call button to appear
            Locator callBtn = page.locator(callButton);
            callBtn.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000)
            );

            // Click the call button
            callBtn.click();
            page.waitForTimeout(8000);
            System.out.println("Call button clicked.");
            page.locator(closeCall).click();
            page.waitForTimeout(3000);
            page.locator(closePopup);
            return true;

        } else {
            String noValidData = page.locator(noDataFound).innerText();
            System.out.println("No valid search data found: " + noValidData);
            return false;
        }
    }

    //==================================== Pages Redirection Method =========================================
    public void homePage() {
        page.waitForTimeout(4000);
        page.locator(home).click();
        page.waitForLoadState(); // Wait for navigation
        String currentURL = page.url();
        System.out.println("Current page: Home | URL: " + currentURL);
    }

    public void peoplePage() {
        page.waitForTimeout(3000);
        page.locator(people).click();
        page.waitForLoadState();
        String currentURL = page.url();
        System.out.println("Current page: People | URL: " + currentURL);
    }

    public void inboxPage() {
        page.waitForTimeout(2000);
        page.locator(inbox).click();
        page.waitForLoadState();
        String currentURL = page.url();
        System.out.println("Current page: Inbox | URL: " + currentURL);
    }

    public void emailMarketingPage() {
        page.waitForTimeout(2000);
        page.locator(emailMarketing).click();
        page.waitForLoadState();
        String currentURL = page.url();
        System.out.println("Current page: Email Marketing | URL: " + currentURL);
    }

    public void socialMediaManagementPage() {
        page.waitForTimeout(2000);
        page.locator(socialMediaManagement).click();
        page.waitForLoadState();
        String currentURL = page.url();
        System.out.println("Current page: Social Media Management | URL: " + currentURL);
    }

    public void tasksPage() {
        page.waitForTimeout(2000);
        page.locator(tasks).click();
        page.waitForLoadState();
        String currentURL = page.url();
        System.out.println("Current page: Tasks | URL: " + currentURL);
    }

    public void dealsPage() {
        page.waitForTimeout(3000);
        page.locator(deals).click();
        page.waitForLoadState();
        String currentURL = page.url();
        System.out.println("Current page: Deals | URL: " + currentURL);
    }

    //==================================== Boxes Method =========================================
    public void verifyAvailableCredit() {
        page.waitForTimeout(2000);
        System.out.println("Box Name: " + page.locator(availableCredit).innerText());
        System.out.println("Total Credit Balance: " + page.locator(creditBalance).innerText());
    }

    public void clickViewCreditHistory() {
        page.locator(creditHistory).click();
        page.waitForTimeout(8000);
        page.goBack();
        page.waitForTimeout(4000);
    }

    public void verifyNewLeads() {
        System.out.println("Box Name: " + page.locator(newLeads).innerText());
        System.out.println("Total New Leads: " + page.locator(totalNewLeads).innerText());
    }

    public void clickViewAllNewLeads() {
        page.locator(newLeadsViewAll).click();
        page.waitForTimeout(8000);
        page.goBack();
        page.waitForTimeout(8000);
    }

    public void verifyTodayTask() {
        System.out.println("Box Name: " + page.locator(todayTask).innerText());
        System.out.println("Total Today's Tasks: " + page.locator(todayTaskCount).innerText());
    }

    public void clickViewAllTodayTask() {
        page.waitForTimeout(2000);
        page.locator(todayTaskViewAll).click();
        page.waitForTimeout(8000);
        page.goBack();
        page.waitForTimeout(8000);
    }

    public void verifyIncompleteFollowUps() {
        System.out.println("Box Name: " + page.locator(incompleteFollowUps).innerText());
        System.out.println("Total Incomplete Follow Ups: " + page.locator(incompleteFollowUpsCount).innerText());
    }

    public void clickViewAllIncompleteFollowUps() {
        page.locator(incompleteFollowUpsViewAll).click();
        page.waitForTimeout(8000);
        page.goBack();
        page.waitForTimeout(4000);
    }

    //================================= Email Marketing methods ==========================================
    public void selectFilterOption(String filter) {
        page.waitForTimeout(3000);
        switch (filter.toLowerCase()) {
            case "today":
                page.selectOption(clickFilter, new SelectOption().setValue("0"));
                page.evaluate("window.scrollBy(0, 400);");
                break;
            case "yesterday":
                page.selectOption(clickFilter, new SelectOption().setValue("1"));
                break;
            case "last 5 days":
                page.selectOption(clickFilter, new SelectOption().setValue("4"));
                break;
            case "last 10 days":
                page.selectOption(clickFilter, new SelectOption().setValue("9"));
                break;
            case "last 30 days":
                page.selectOption(clickFilter, new SelectOption().setValue("29"));
                break;
            default:
                throw new RuntimeException("Invalid filter option: " + filter);
        }
    }

    public void verifyEmailMarketingStats(String filter) {
        page.waitForTimeout(2000);
        String label = filter.substring(0, 1).toUpperCase() + filter.substring(1).toLowerCase();

        System.out.println("===== Verifying Email Marketing for: " + label + " =====");

        String clickRate = "//p[normalize-space()='Click Rate']";
        String clickRatePercentage = "//p[text()='Click Rate']/following-sibling::div/p";

        String openRate = "//p[normalize-space()='Open Rate']";
        String openRatePercentage = "//p[text()='Open Rate']/following-sibling::div/p";

        String unsubscribed = "//p[normalize-space()='Unsubscribed']";
        String unsubscribedPercentage = "//p[text()='Unsubscribed']/following-sibling::div/p";

        String clicksPerUniqueOpens = "//p[normalize-space()='Clicks Per Unique Opens']";
        String clicksPerUniqueOpensPercentage = "//p[text()='Clicks Per Unique Opens']/following-sibling::div/p";

        System.out.println("Name: " + page.locator(clickRate).innerText());
        System.out.println(label + " Click Rate %: " + page.locator(clickRatePercentage).innerText());

        System.out.println("Name: " + page.locator(openRate).innerText());
        System.out.println(label + " Open Rate %: " + page.locator(openRatePercentage).innerText());

        System.out.println("Name: " + page.locator(unsubscribed).innerText());
        System.out.println(label + " Unsubscribed %: " + page.locator(unsubscribedPercentage).innerText());

        System.out.println("Name: " + page.locator(clicksPerUniqueOpens).innerText());
        System.out.println(label + " Clicks Per Unique Opens %: " + page.locator(clicksPerUniqueOpensPercentage).innerText());

    }

    public void setViewMore() {
        page.locator(viewMore).click();
        page.waitForTimeout(3000);
        System.out.println("Redirected on Email Marketing page");
    }

    //==================================== Tasks Method ==============================================
    public void tasksCheckbox() {
        page.waitForTimeout(2000);
        page.locator(appointmentCheckbox).scrollIntoViewIfNeeded();
        page.locator(appointmentCheckbox).click();

        page.waitForTimeout(2000);
        page.locator(emailSchedulesCheckbox).scrollIntoViewIfNeeded();
        page.locator(emailSchedulesCheckbox).click();

        page.waitForTimeout(2000);
        page.locator(taskCheckbox).scrollIntoViewIfNeeded();
        page.locator(taskCheckbox).click();

        page.waitForTimeout(2000);
        page.locator(socialMediaSchedulesCheckbox).scrollIntoViewIfNeeded();
        page.locator(socialMediaSchedulesCheckbox).click();
    }

    public void viewMoreCheckbox() {
        page.waitForTimeout(3000);
        page.locator(viewMoreCheckbox).scrollIntoViewIfNeeded();
        page.locator(viewMoreCheckbox).click();
        System.out.println("Redirect successfully on Task page");
    }

    //==================================== Automation Method ==============================================
    public void automationViewMore() {
        page.waitForTimeout(3000);
        page.locator(automationViewAll).click();
    }

    public void automationPage() {
        page.waitForTimeout(2000);
        page.waitForLoadState();
        String currentURL = page.url();
        System.out.println("Current page: Automation | URL: " + currentURL);
    }

    //==================================== Social Media Methods ==============================================
    public void selectSocialMediaAccount(String accountType) {
        page.waitForTimeout(2000);
        page.locator(socialMediaDropdown).click();
        switch (accountType.toLowerCase()) {
            case "facebook":
                page.waitForTimeout(2000);
                page.evaluate("window.scrollBy(0, 450);");
                page.waitForTimeout(2000);
                page.locator(selectFacebook).click();
                break;
            case "instagram":
                page.waitForTimeout(2000);
                page.locator(selectInstagram).click();
                break;
            default:
                throw new RuntimeException("Invalid social media account type: " + accountType);
        }
    }

    public void applyFilter(String filter) {
        page.waitForTimeout(2000);
        switch (filter.toLowerCase()) {
            case "today":
                page.selectOption(socialMediaFilter, new SelectOption().setValue("0"));
                break;
            case "yesterday":
                page.selectOption(socialMediaFilter, new SelectOption().setValue("1"));
                break;
            case "last 5 days":
                page.selectOption(socialMediaFilter, new SelectOption().setValue("4"));
                break;
            case "last 10 days":
                page.selectOption(socialMediaFilter, new SelectOption().setValue("9"));
                break;
            case "last 30 days":
                page.selectOption(socialMediaFilter, new SelectOption().setValue("29"));
                break;
            default:
                throw new RuntimeException("Invalid filter option: " + filter);
        }
    }

    public void applyAllFilters() {
        String[] filters = {"today", "yesterday", "last 5 days", "last 10 days", "last 30 days"};
        for (String filter : filters) {
            applyFilter(filter);
            page.waitForTimeout(2000);
        }
    }

    public void clickViewMore() {
        page.locator(viewMoreSocialMedia).click();
        page.waitForTimeout(3000);
        System.out.println("Navigate to the Social Media Management page");
    }
}

