import data.ConstData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.GamePage;
import pages.HomePage;

public class Steps {


    private WebDriver driver;
    private HomePage homePage;
    private GamePage gamePage;

    @Given("I am on the Home page")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConstData.URL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        gamePage = new GamePage(driver);
    }

    @When("I click on the Menu bar button")
    public void clickMenuBarButton() {
        homePage.clickMenuBarButton();
    }

    @When("I click on particular game")
    public void clickGame() {
        homePage.clickFirstGame();
    }

    @When("I Get information about a specific game from the site's API")
    public void assertGameNameIsTrue() {
        Assert.assertEquals(gamePage.getGameNameTextUI(), gamePage.getGameNameTextAPI());
    }

    @When("I Parse response to get the most voted option in the Language Dependence poll")
    public void assertLanguageDependenceIsTrue() {
        Assert.assertEquals(gamePage.getLanguageDependenceTextUI(), gamePage.getLanguageDependenceTextAPI());
    }

    @Then("Assert Language Dependence text presented in the game page Description block equals the most voted Language Dependence level.")
    public void assertDescriptionIsTrue() {
        Assert.assertEquals(gamePage.getDescriptionTextUI(), gamePage.getDescriptionTextAPI());
    }
}
