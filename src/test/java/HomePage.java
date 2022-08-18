import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By menuBarPath = By.className("menu-bars");
    private By firstGamePath = By.cssSelector("[class='geeksidebar-links hotness tw-m-0 tw-list-none tw-p-0'] :nth-child(1)");


    public void clickMenuBarButton() {
        driver.findElement(menuBarPath).click();
    }

    public void clickFirstGame() {
        driver.findElement(firstGamePath).click();
    }
}
