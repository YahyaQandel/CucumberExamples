package pages.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

import java.util.List;

public class Home extends Base {

//  @FindBy(name="keyword")
    @FindBy(css="form input")
    WebElement searchField;
    @FindBy(css="form button")
    WebElement searchIconField;
    @FindBy(css="main header span")
    WebElement searchResultsText;
    @FindBy(css="main figcaption")
    List<WebElement> searchResultsList;
    public Home(WebDriver driver){
        super(driver);
        URL = "https://djangogreatkart.com/store";
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
    public boolean isItemExistsInSearchResults(String itemTitle){
        performWaitForElement(searchResultsList);
        System.out.printf("Found Items : %d%n",searchResultsList.size());
        System.out.println("-----------");
        for (WebElement resultItem : searchResultsList){
            String foundItemTitle = resultItem.findElement(By.tagName("a")).getText();
            System.out.println(foundItemTitle);
            if (foundItemTitle.equals(itemTitle)){
                return true;
            }
        }
        return false;
    }
}