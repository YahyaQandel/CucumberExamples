package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
//
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        tags = "not @flakyTest",
        plugin = {"pretty", "html:target/features-reports/reports.html","json:target/features-reports/reports.json"},
        glue = "steps"
)
class TestRunner {
    @BeforeClass
    public static void beforeAll(){
        System.out.println("Before all step definitions");
    }
}
