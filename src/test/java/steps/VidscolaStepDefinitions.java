package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VidscolaStepDefinitions {

    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        this.driver = new ChromeDriver(chromeOptions);
    }

    @Given("I visit {string}")
    public void iVisit(String url) {
        driver.get(url);
    }

    @When("I select the search icon")
    public void iSelectTheSearchIcon() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("navbar-search__toggle"))
        );
        searchIcon.click();
    }

    @And("I search for {string}")
    public void iSearchFor(String courseName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchBar = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("s"))
        );
        searchBar.sendKeys(courseName);
        searchBar.sendKeys(Keys.ENTER);
    }

    @And("I select AGILE TESTING AUTOMATION WORKSHOP course")
    public void iSelectAGILETESTINGAUTOMATIONWORKSHOPCourse() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement agileTestingAutomationCourse = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-662\"]/div/div[3]/h3/a"))
        );
        agileTestingAutomationCourse.click();
    }

    @Then("I should find {string} as course title")
    public void iShouldFindAsCourseTitle(String expectedCourseTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement courseTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("course__title"))
        );
        Assert.assertEquals(expectedCourseTitle, courseTitle.getText());
    }
    @After
    public void teardown(){
        this.driver.close();
    }

}
