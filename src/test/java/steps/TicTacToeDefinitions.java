package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.tictactoe.TicTacToeHome;

import static org.junit.Assert.assertEquals;

public class TicTacToeDefinitions {
    private WebDriver driver;
    private TicTacToeHome tictactoe ;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        this.driver = new ChromeDriver(chromeOptions);
        tictactoe = new TicTacToeHome(this.driver);
    }
    @When("I visit tictactoe game board site")
    public void iVisitTicTacToeGameBoardSite() {
        tictactoe.visit();
    }

    @When("player {string} plays in cell {int}")
    public void PlayerPlaysInCell(String playerName,int cellIndex){
        tictactoe.PlayOn(cellIndex);
    }

    @Then("game board should display winner is {string}")
    public void gameBoardShouldDisplay(String winnerChar){
        assertEquals(tictactoe.winner(),winnerChar);
    }

    @After
    public void teardown(){
        this.driver.close();
    }

}
