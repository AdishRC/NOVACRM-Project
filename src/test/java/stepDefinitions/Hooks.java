package stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
    TestContextSetup context;

    public Hooks(TestContextSetup context) {
        this.context = context;
    }

    @After
    public void tearDown() {
        context.testBase.closeBrowser();
    }
}






