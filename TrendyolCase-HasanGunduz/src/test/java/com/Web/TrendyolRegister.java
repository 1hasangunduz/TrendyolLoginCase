package com.Web;

import com.basepages.BaseTest;
import com.data.GetData;
import com.trendyolpages.TrendyoLoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TrendyolRegister extends BaseTest {

    @Epic("Trendyol'da Login olabilmek için; Üyelik oluşturma.")
    @Story("Kullanıcının 'Giriş yap' butonuna tıklayıp, üyelik oluşturma işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Register_With_The_Sign_In_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnRegister(GetData.TRENDYOL_LOGIN_ROUTE.HOMEPAGELOGIN.value)
                .registerCustomer(GetData.TRENDYOL_REGISTER_DATA.EMAIL.value, GetData.TRENDYOL_REGISTER_DATA.PASSWORD.value);

    }

    @Epic("Trendyol'da Login olabilmek için; Üyelik oluşturma.")
    @Story("Kullanıcının 'Favorilerim' butonuna tıklayıp, üyelik oluşturma işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Register_With_My_Favorites_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnRegister(GetData.TRENDYOL_LOGIN_ROUTE.FAVORITES.value)
                .registerCustomer(GetData.TRENDYOL_REGISTER_DATA.EMAIL.value, GetData.TRENDYOL_REGISTER_DATA.PASSWORD.value);

    }

    @Epic("Trendyol'da Login olabilmek için; Üyelik oluşturma.")
    @Story("Kullanıcının 'IndirimKuponlarım' butonuna tıklayıp, üyelik oluşturma işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Register_With_Discount_Coupons_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnRegister(GetData.TRENDYOL_LOGIN_ROUTE.DISCOUNT.value)
                .registerCustomer(GetData.TRENDYOL_REGISTER_DATA.EMAIL.value, GetData.TRENDYOL_REGISTER_DATA.PASSWORD.value);

    }

    @Epic("Trendyol'da Login olabilmek için; Üyelik oluşturma.")
    @Story("Kullanıcının 'Sepetim' butonuna tıklayıp, üyelik oluşturma işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Sepete ürün eklenir, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Register_With_Shop_Cart_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnRegister(GetData.TRENDYOL_LOGIN_ROUTE.BASKET.value)
                .registerCustomer(GetData.TRENDYOL_REGISTER_DATA.EMAIL.value, GetData.TRENDYOL_REGISTER_DATA.PASSWORD.value);
    }

}
