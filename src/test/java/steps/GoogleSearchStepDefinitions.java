package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSearchStepDefinitions {

    private WebDriver driver;
    private static final String GOOGLE_WEBSITE_URL = "https://www.google.com/?hl=en";
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        this.driver = new ChromeDriver(chromeOptions);
    }

    @Given("user navigates to google.com search screen")
    public void iGoToVodafoneWebsite() {
        driver.get(GOOGLE_WEBSITE_URL);
    }

    @When("user types {string} in search text field")
    public void userTypesInSearchTextField(String textToSearch) {
        WebElement searchTextField = waitForElementToBeVisible(By.name("q"));
        searchTextField.sendKeys(textToSearch);
    }

    @And("user clicks Google search or press enter")
    public void userClicksOnSearchBtn() {
        WebElement searchBtn = waitForElementToBeVisible(By.name("btnK"));
        searchBtn.click();
    }

    @Then("user should be navigated to search page with title {string} and url contains {string}")
    public void userShouldBeNavigatedToSearchPage(String titleText,String urlText) {
        String currentPageUrl = driver.getCurrentUrl();
        String [] urlTextToSearch = urlText.split(",");
        for (String textToSearch : urlTextToSearch) {
            assertTrue(currentPageUrl.contains(textToSearch));
        }
        assertEquals(driver.getTitle(),titleText);
    }

    WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }
    @After
    public void teardown(){
        this.driver.close();
    }

}
