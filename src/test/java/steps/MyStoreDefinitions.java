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
import pages.mystore.Home;

public class MyStoreDefinitions {
    private WebDriver driver;
    private Home myStoreHomePage ;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        this.driver = new ChromeDriver(chromeOptions);
    }
    @When("I visit mystore website")
    public void iVisitMyStoreWebsite() {
        myStoreHomePage = new Home(this.driver);
    }

    @When("I type {string} in search field and press search icon")
    public void iTypeInSearchField(String textToSearchBy) {
        myStoreHomePage.searchFor(textToSearchBy);
    }

    @Then("I should find {int} items")
    public void iShouldFindResultsFound(int searchResultsCount) {
        // TODO: should change responsibility of checking contains to equal inside `getSearchResultsText`
        Assert.assertTrue(myStoreHomePage.getSearchResultsText().contains(String.valueOf(searchResultsCount)));
    }

    @And("I should find {string} in results items")
    public void iShouldFindInPageHeading(String itemTitle) {
        Assert.assertTrue(myStoreHomePage.isItemExistsInSearchResults(itemTitle));
    }
    @After
    public void teardown(){
        this.driver.close();
    }

}
