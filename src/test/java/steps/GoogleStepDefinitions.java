package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleStepDefinitions {
    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        this.driver = new ChromeDriver(chromeOptions);
    }

    @Given("I go to {string}")
    public void iVisit(String url) {
        driver.get(url);
    }


    @When("I select auto detect language")
    public void iSelectAutoDetectLanguage() {
        WebElement autoDetectLanguageButton = waitForElementsToBeVisible(By.cssSelector("button[data-language-code=\"auto\"]"));
        autoDetectLanguageButton.click();
    }

    @And("choose to translate into Arabic")
    public void translateIntoArabic() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement moreLanguagesButton = waitForElementsToBeVisible(By.cssSelector("button[aria-label=\"More target languages\"]"));
        moreLanguagesButton.click();
        WebElement arabicLanguageOption = waitForElementsToBeVisible(By.cssSelector("button[data-language-code=\"ar\"]"));
        arabicLanguageOption.click();
        moreLanguagesButton.click();

    }

    @And("Type {string}")
    public void type(String text) {
        WebElement moreLanguagesButton = waitForElementsToBeVisible(By.cssSelector("button[aria-label=\"More target languages\"]"));
        moreLanguagesButton.click();
        WebElement translationTextBox = waitForElementsToBeVisible(By.className("er8xn"));
        translationTextBox.sendKeys(text);
    }

    @Then("Should translate into {string}")
    public void shouldTranslateInto(String arabicText) {
        waitForElementsToBeVisible(By.xpath("//*[text()[contains(.,'" +  arabicText + "')]]"));
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
