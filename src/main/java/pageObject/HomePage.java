package pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import utils.TestContextSetup;

public class HomePage {
    private final Page page;

    //Search Locators
//    private final String search = "[placeholder='Search']";
//    private final String clickLeadName = "(//ul[@class='top-search']//li)[1]";
//    private final String checkLeadName = "//h2[contains(@class, 'LeadDetailsPage_profileName')]";

    //Notification Locators
//    private final String notificationCount = "//span[@class='notification_circle notification_circle_color']";
//    private final String notificationIconClick = "//a[contains(@class, 'btn pt-1 pb-1')]//*[name()='svg' and contains(@class, 'size-22')]";


    //Add new lead Locators
//    private final String addAPerson = "//button[@class='btn nova-bg-sky bottom-header-icon ']";
//    private final String firstName = "//input[@placeholder='First name *']";
//    private final String lastName = "//input[contains(@placeholder,'Last name')]";
//    private final String emailAddress = "//input[@placeholder='Email Address *']";
//    private final String duplicateEmailAddress = "//span[normalize-space()='The email address has already been taken.']";
//    private final String countryCode = "//select[@id='country_code']";
//    private final String phoneNo = "//input[@placeholder='Phone No. *']";
//    private final String duplicatePhoneNo = "//span[normalize-space()='The contact number has already been taken.']";
//    private final String saveLead = "//button[normalize-space()='Save Lead']";

    //Add a text Locators
    private final String addTextIcon = "//button[@title='Send a text']";
    private final String enterName = "//input[@placeholder='Enter name or phone number']";     //Raghav 1st
    private final String roleButton = "//li[@role='button']";
    private final String writeText = "//textarea[@placeholder='Write your text']";        // Hii, How Are You
    private final String sendMessage = "//button[normalize-space()='Send Message']";


    public HomePage(TestContextSetup context) {
        this.page = context.page;
    }

//    public void validateSearchFunctionality() {
//        try {
//            page.waitForTimeout(4000);
//            page.waitForSelector("p.Homepage_name__4nOLC");
//
//            // Enter search term
//            page.locator(search).fill("Rajat");
//            page.waitForTimeout(1000); // Allow suggestions to appear
//
//            // Check if any search suggestions exist
//            Locator results = page.locator("ul.top-search li");
//            int count = results.count();
//
//            if (count > 0) {
//                // Click first item from results
//                page.locator(clickLeadName).click();
//
//                // Wait for lead details page to load
//                page.waitForSelector(checkLeadName); // Wait for name to be visible
//                String actualLeadName = page.locator(checkLeadName).innerText();
//
//                // Print the lead name
//                System.out.println("Lead Name from Details Page: " + actualLeadName);
//
//            } else {
//                System.out.println("No search results found");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Search operation failed: " + e.getMessage());
//        }
//    }


//    public void notificationCountMsg() {
//        Locator notify = page.locator(notificationCount);
//        notify.waitFor();
//        int Count = Integer.parseInt(page.locator(notificationCount).innerText());
//        System.out.println("Notification message count:- " + Count);
//
//    }
//
//    public void notificationIcon() {
//        Locator notify = page.locator(notificationIconClick);
//        notify.waitFor();
//        page.locator(notificationIconClick).click();
//        System.out.println("Notification modal page open successfully");
//    }


//    public void addNewLead() {
//        page.waitForTimeout(2000);
//
//        page.locator(addAPerson).click();
//        page.locator(firstName).fill("Raghav");
//        page.locator(lastName).fill("Kumar");
//
//        page.locator(emailAddress).fill("raghav@mmnovatech.com");
//
//        page.locator(countryCode).click();
//        page.selectOption("#country_code", new SelectOption().setLabel("+91"));
//        page.locator(phoneNo).fill("9032590106");
//
//        // Click Save to trigger validation
//        page.locator(saveLead).click();
//
//        page.waitForTimeout(2000); // wait for error to appear
//
//        boolean isDuplicateEmail = page.locator(duplicateEmailAddress).isVisible();
//        boolean isDuplicatePhone = page.locator(duplicatePhoneNo).isVisible();
//
//        if (isDuplicateEmail) {
//            String duplicateEmail = page.locator(duplicateEmailAddress).innerText();
//            throw new AssertionError("Test Failed: Duplicate Email Detected - " + duplicateEmail);
//        }
//
//        if (isDuplicatePhone) {
//            String duplicatePhone = page.locator(duplicatePhoneNo).innerText();
//            throw new AssertionError("Test Failed: Duplicate Phone Detected - " + duplicatePhone);
//        }
//
//        System.out.println("Save new lead successfully");
//    }


    public void sendTextIcon() {
        page.waitForTimeout(6000);
        page.locator(addTextIcon).click();
    }

    public void enterName() {
        page.waitForTimeout(4000);

        page.locator(enterName).fill("Raghav");

        Locator results = page.locator("//li[@role='button']");
        results.first().waitFor(new Locator.WaitForOptions().setTimeout(5000));

        int count = results.count();

        if (count > 0) {
            results.nth(0).click();

            // ✅ Replace fixed wait with proper wait for the text box to appear
            Locator messageInput = page.locator(writeText);
            messageInput.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000)
            );

            // ✅ Also check it is enabled before filling
            if (!messageInput.isEnabled()) {
                throw new AssertionError("Message input is not enabled for typing!");
            }

            messageInput.fill("Hii, How Are You?");

            String actualRoleButton = results.nth(0).innerText();
            System.out.println("Lead Name: " + actualRoleButton);

        } else {
            throw new AssertionError("Search operation failed: No search results found for 'Raghav'");
        }
    }

    public void sendMessageButton() {
        Locator sendMessageButton = page.locator(sendMessage);

        // Wait for visible + enabled state
        sendMessageButton.waitFor(new Locator.WaitForOptions().setTimeout(5000).setState(WaitForSelectorState.VISIBLE));

        if (!sendMessageButton.isEnabled()) {
            throw new AssertionError("Send Message button is not enabled!");
        }

        sendMessageButton.click();
        System.out.println("Send Message button clicked.");
}

}