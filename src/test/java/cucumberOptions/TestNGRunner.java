package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/main/resources/A_login.feature",
                "src/main/resources/B_homepage.feature",
                "src/main/resources/people.feature",
        },
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "pretty"
        }
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
//        @Override
//        @DataProvider(parallel=true)
//        public Object[][] scenarios()
//        {
//                return super.scenarios();
//        }
}

