package pages.tictactoe;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

import java.util.List;

public class BoardSquare extends Base{
    @FindBy(css = "[id^='square-']")
    private List<WebElement> squares;

    private WebElement square;

    protected BoardSquare(WebDriver driver,int squareIndex) {
        super(driver);
        initElements(this);
        this.square = this.squares.get(squareIndex - 1);
    }

    public WebElement get(){
        return this.square;
    }

    public void click(){
        this.square.click();
    }
}
