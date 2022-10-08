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

public class TrendyoLogin extends BaseTest {


    @Epic("Trendyol'da; Kayıtlı kullanıcı ile login olma.")
    @Story("Kullanıcının 'Giriş yap' butonuna tıklayıp, Login işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Login_With_The_Sign_In_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnLogin(GetData.TRENDYOL_LOGIN_ROUTE.HOMEPAGELOGIN.value)
                .loginCustomer(GetData.TRENDYOL_LOGIN_DATA.EMAIL.value, GetData.TRENDYOL_LOGIN_DATA.PASSWORD.value);

    }

    @Epic("Trendyol'da; Kayıtlı kullanıcı ile login olma.")
    @Story("Kullanıcının 'Favorilerim' butonuna tıklayıp, Login işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Login_With_My_Favorites_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnLogin(GetData.TRENDYOL_LOGIN_ROUTE.FAVORITES.value)
                .loginCustomer(GetData.TRENDYOL_LOGIN_DATA.EMAIL.value, GetData.TRENDYOL_LOGIN_DATA.PASSWORD.value);

    }

    @Epic("Trendyol'da; Kayıtlı kullanıcı ile login olma.")
    @Story("Kullanıcının 'IndirimKuponlarım' butonuna tıklayıp, Login işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Login_With_Discount_Coupons_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnLogin(GetData.TRENDYOL_LOGIN_ROUTE.DISCOUNT.value)
                .loginCustomer(GetData.TRENDYOL_LOGIN_DATA.EMAIL.value, GetData.TRENDYOL_LOGIN_DATA.PASSWORD.value);

    }

    @Epic("Trendyol'da; Kayıtlı kullanıcı ile login olma.")
    @Story("Kullanıcının 'Sepetim' butonuna tıklayıp, Login işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Sepete ürün eklenir, Üyelik tabına gidilir ve Email, Password, checkBox ve Gender alanları doldurulup işaretlenir.")
    @Test
    @Parameters({"addUrlPlugin"})
    public void Login_With_Shop_Cart_Button(@Optional("") String addUrlPlugin) throws InterruptedException {

        new TrendyoLoginPage()
                .navigateToUrl(addUrlPlugin)
                .btnLoginForCart(GetData.TRENDYOL_LOGIN_ROUTE.BASKET.value)
        ;
    }

}
