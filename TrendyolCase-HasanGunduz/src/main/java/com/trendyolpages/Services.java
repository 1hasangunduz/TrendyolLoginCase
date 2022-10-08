package com.trendyolpages;

import com.driver.DriverManager;
import com.utility.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Services {

    // Search edilecek inputların girildiği box.
    @FindBy(css = ".search-box")
    WebElement searchBox;
    //Arama imleci.
    @FindBy(css = ".search-icon")
    WebElement exploration;


    public Services() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public TrendyoLoginPage checkTitleValues() throws InterruptedException {
        Response response = RestAssured
                .get("https://www.omdbapi.com/?s=Batman&page=2&apikey=37e68820")
                .then()
                .extract()
                .response();

        List<String> searchTitle = response.jsonPath().getList("Search.Title");
        for (String title : searchTitle) {

            Log.pass("-------------------------------------------");

            searchBox.sendKeys(title);
            Log.pass("Search Box'a yazılan text : " + title);

            exploration.click();
            Log.pass("Search butonuna tıklandı.");

            Thread.sleep(4000);
            Log.pass("Status Code: " + response.getStatusCode());

            searchBox.clear();
            Log.pass("Search Box içerisindeki textler temizlendi.");

        }
        return new TrendyoLoginPage();
    }


}
