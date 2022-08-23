package pages;

import data.ConstData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import requests.Requests;



public class GamePage {
    WebDriver driver;
    Requests requests;

    private By languageDependencePath = By.cssSelector("[ng-bind-html='geekitemctrl.geekitem.data.item.polls.languagedependence|to_trusted']");
    private By nameGamePath = By.cssSelector("[ui-sref='geekitem.overview'][class='ng-binding']");
    private By description = By.cssSelector("[ng-bind-html='geekitemctrl.wikitext|to_trusted']:nth-child(1)");
    int maxVotesValue = 0;
    int maxValue = 0;

    public GamePage(WebDriver driver) {
        this.driver = driver;
        requests = new Requests(driver);
    }

    public String getGameNameTextUI() {
        return driver.findElement(nameGamePath).getText();
    }

    public String getGameNameTextAPI() {
        return requests.getResponse(requests.getId(), ConstData.nameXMLPath);
    }

    public String getLanguageDependenceTextUI() {
        return driver.findElement(languageDependencePath).getText();
    }

    public String getLanguageDependenceTextAPI() {
        if (Integer.parseInt(requests.getResponse(requests.getId(), ConstData.totalvotesXMLPath)) == 0)
            return "(no votes)";
        else
            for (int i = 1; i <= 5; i++) {
                if (Integer.parseInt(requests.getResponse(requests.getId(), ConstData.numvotesXMLPath(i))) > maxVotesValue) {
                    maxVotesValue = Integer.parseInt(requests.getResponse(requests.getId(), ConstData.numvotesXMLPath(i)));
                    maxValue = i;
                }
            }
        return requests.getResponse(requests.getId(), ConstData.valueXMLPath(maxValue));
    }

    public String getDescriptionTextUI() {
        return driver.findElement(description).getText().replaceAll("\n", "");
    }

    public String getDescriptionTextAPI() {
        return requests.getResponse(requests.getId(), ConstData.descriptionXMLPath).replaceAll("<br/>", "");
    }

}
