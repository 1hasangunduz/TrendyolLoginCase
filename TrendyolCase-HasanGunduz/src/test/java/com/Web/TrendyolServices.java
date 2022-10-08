package com.Web;

import com.basepages.BaseTest;
import com.trendyolpages.Services;
import com.trendyolpages.TrendyoLoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;


public class TrendyolServices extends BaseTest {

    @Epic("Trendyol'da; Endpoint içerisindeki verileri alma ve kontrol etme.")
    @Description("Endpoint'e istek atılır ve içerisindeki Search arrays altındaki; Title değerleri,teker teker Trendyol saysından search edilerek status codeları kontrol edilir. ")
    @Test
    public void Control_SearchTitle_TrenyolPage() throws InterruptedException{

        new TrendyoLoginPage()
                .navigateToUrl("");
        new Services()
                .checkTitleValues();
    }
}
