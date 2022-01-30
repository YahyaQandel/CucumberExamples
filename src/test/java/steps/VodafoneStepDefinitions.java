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

import java.util.List;

public class VodafoneStepDefinitions {

    private WebDriver driver;
    private static final String VODAFONE_WEBSITE_URL = "https://web.vodafone.com.eg/en";
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        this.driver = new ChromeDriver(chromeOptions);
    }

    @Given("I go to vodafone website")
    public void iGoToVodafoneWebsite() {
        driver.get(VODAFONE_WEBSITE_URL);
    }

    @When("I click on the search icon")
    public void iClickOnSearchIcon() {
        WebElement searchIcon = waitForElementsToBeVisible(By.id("searchIcon"));
        searchIcon.click();
    }

    @And("I type in search field {string}")
    public void iTypeInSearchField(String textToSearch) {
        WebElement searchField = waitForElementsToBeVisible(By.id("search"));
        searchField.sendKeys(textToSearch);
        searchField.sendKeys(Keys.ENTER);
    }

    @Then("I Should find {string} as the first result")
    public void iShouldFind(String searchResultText) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
         List <WebElement> searchResultsElements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("result"))
        );
         WebElement firstSearchResult = searchResultsElements.get(0);
        Assert.assertEquals(searchResultText,firstSearchResult.getText());
    }

    WebElement waitForElementsToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }
    @After
    public void teardown(){
        this.driver.close();
    }

}
