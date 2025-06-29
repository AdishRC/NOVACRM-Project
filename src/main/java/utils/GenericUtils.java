package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class GenericUtils {
    public Page page;

    public GenericUtils(Page page) {
        this.page = page;
    }

    public Locator waitForElement(String selector) {
        Locator locator = page.locator(selector);
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.valueOf("visible")));

        return locator;
    }

    public Locator waitForElementToBeClickable(String selector) {
        Locator locator = page.locator(selector);
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.valueOf("visible")));
        return locator; // Playwright auto-handles clickability
    }

    public void clickWhenVisible(String selector) {
        waitForElementToBeClickable(selector).click();
    }

    public void fillWhenVisible(String selector, String text) {
        waitForElement(selector).fill(text);
    }
}

