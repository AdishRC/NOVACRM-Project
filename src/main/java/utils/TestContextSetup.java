package utils;

import com.microsoft.playwright.Page;
import java.io.IOException;

public class TestContextSetup {
    public TestBase testBase;
    public Page page;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        this.page = testBase.initializePage();
        this.genericUtils = new GenericUtils(page);
    }
}

