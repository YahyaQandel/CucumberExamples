package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {
    WebDriver driver;
    private final WebDriverWait wait;
    protected String URL;
    protected Base(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
    }
    protected void initElements(Object child){
        PageFactory.initElements(driver, child);
    }

    public void visit(){
        this.driver.get(URL);
    }
    protected void performWait(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void performWait(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
