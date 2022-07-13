package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

public class Home extends Base {

    @FindBy(id="search_query_top")
    WebElement searchField;
    @FindBy(name="submit_search")
    WebElement searchIconField;
    @FindBy(className="heading-counter")
    WebElement searchResultsText;
    @FindBy(className="lighter")
    WebElement searchResultsPageHeading;
    public Home(WebDriver driver){
        super(driver);
        URL = "http://automationpractice.com/index.php";
        initElements(this);
    }

    public void searchFor(String textToSearchBy){
        performWaitForElement(searchField);
        searchField.sendKeys(textToSearchBy);
        performWaitForElement(searchIconField);
        searchIconField.click();
    }
    public String getSearchResultsText(){
        performWaitForElement(searchResultsText);
        return searchResultsText.getText();
    }
    public String getSearchResultsPageHeadingText(){
        performWaitForElement(searchResultsPageHeading);
        return searchResultsPageHeading.getText();
    }
}