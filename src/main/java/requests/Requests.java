package requests;

import data.ConstData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;


public class Requests {
    private WebDriver driver;

    public Requests(WebDriver driver) {
        this.driver = driver;
    }

    public String getId() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.replaceAll("https://boardgamegeek.com/boardgame/", "").split("/")[0];
    }

    public String getResponse(String id, String XMLPath) {
        return
                RestAssured.given().when()
                        .get(ConstData.XMLApi + id)
                        .then()
                        .contentType(ContentType.XML)
                        .extract()
                        .path(XMLPath);
    }

}
