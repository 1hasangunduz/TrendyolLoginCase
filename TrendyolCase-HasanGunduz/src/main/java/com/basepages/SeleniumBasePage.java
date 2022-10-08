package com.basepages;

import com.driver.DriverManager;
import com.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class SeleniumBasePage {

    //Scroll etmek istediğimiz zaman js'te driver null dönmemesi için gerekli.
    public WebDriver driver=DriverManager.getDriver() ;

    //Elementeleri merkeze alarak scroll eder.
    public void scrollToElementBlockCenter(WebElement element, String whereToScroll) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Log.pass("Scroll işleminin başarıyla gerçekleştiği obje :  " + whereToScroll);
        } catch (Exception e) {
            Log.fail("Error while scrolling to the element : ", e);
        }

    }

    public void switchToWindow() {
        for (String handle : DriverManager.getDriver().getWindowHandles()) {
            DriverManager.getDriver().switchTo().window(handle);
        }
    }


}
