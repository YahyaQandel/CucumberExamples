package pages.tictactoe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

import java.util.List;

public class TicTacToeHome extends Base {
    // board cells
    @FindBy(id = "go-to-move-btn")
    List<WebElement> goToMoveBtn;

    @FindBy(id = "winner")
    WebElement winnerLabel;
    private final WebDriver driver;

    public TicTacToeHome(WebDriver driver) {
        super(driver);
        this.driver = driver;
        URL = "https://tictactoe.automationtesting.tech";
        initElements(this);
    }

    public void PlayOn(int boardCellIndex) {
        BoardSquare square = new BoardSquare(this.driver, boardCellIndex);
        square.click();
    }

    public String winner(){
        performWait(winnerLabel);
        return winnerLabel.getText();
    }

}
