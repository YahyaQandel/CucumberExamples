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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStoreDefinitions {
    private WebDriver driver;
    private static final String MYSTORE_WEBSITE_URL = "http://automationpractice.com/index.php";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        this.driver = new ChromeDriver(chromeOptions);
    }
    @When("I visit mystore website")
    public void iVisitMyStoreWebsite() {
        driver.get(MYSTORE_WEBSITE_URL);
    }

    @When("I type {string} in search field")
    public void iTypeInSearchField(String textToSearchBy) {
        final String searchFieldIdentifier = "search_query_top";
        WebElement searchField = waitForElementsToBeVisible(By.id(searchFieldIdentifier));
        searchField.sendKeys(textToSearchBy);
    }

    @And("I press search icon")
    public void iPressSearchIcon() {
        final String searchIconElementName = "submit_search";
        WebElement searchIconField = waitForElementsToBeVisible(By.name(searchIconElementName));
        searchIconField.click();
    }

    @Then("I should find {int} results found")
    public void iShouldFindResultsFound(int searchResultsCount) {
        final String searchResultsTextElementClass = "heading-counter";
        WebElement searchResultsTextElement = waitForElementsToBeVisible(By.className(searchResultsTextElementClass));
        Assert.assertTrue(searchResultsTextElement.getText().contains(String.valueOf(searchResultsCount)));
    }

    @And("I should find {string} in page heading")
    public void iShouldFindInPageHeading(String textUsedInSearch) {
        final String searchResultsPageHeadingElementClass = "lighter";
        WebElement searchResultsPageHeadingElement = waitForElementsToBeVisible(By.className(searchResultsPageHeadingElementClass));
        String searchResultsPageHeadingText = searchResultsPageHeadingElement.getText();
        Assert.assertEquals(textUsedInSearch,searchResultsPageHeadingText);
    }
    @After
    public void teardown(){
        this.driver.close();
    }

    WebElement waitForElementsToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
