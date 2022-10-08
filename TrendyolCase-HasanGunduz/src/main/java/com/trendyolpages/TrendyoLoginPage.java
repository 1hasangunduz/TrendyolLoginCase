package com.trendyolpages;


import com.basepages.*;
import com.data.GetData;
import com.driver.DriverManager;
import com.utility.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TrendyoLoginPage extends SeleniumBasePage {


    //Homepage'teki popup modalı kapatmak için.
    @FindBy(css = ".modal-close")
    WebElement btnClosePopUp;

    //Giriş yap ikon alanı.
    @FindBy(css = ".link.account-user")
    WebElement btnUserLogin;

    //Favorilerim ikon alanı.
    @FindBy(xpath = "//div[@class='account-nav-item user-login-container']")
    WebElement btnFovorites;

    //Sepetim ikonun alanı ve sepete ürün ekleme.
    @FindBy(xpath = "//div[@class='account-nav-item basket-preview']")
    WebElement btnShopCart;
    @FindBy(xpath = "(//div[@class='pb-summary-approve'])[1]")
    WebElement btnShopCartToApprove;
    @FindBy(xpath = "(//div[@class='p-card-wrppr basket-active'])[1]")
    WebElement chooseProduct;
    @FindBy(xpath = "//button[@class='add-to-basket']")
    WebElement addToBasket;
    // /sepetim/odeme altındaki gel al noktası seç modal içeriği
    @FindBy(xpath = "//div[@class='p-onboarding-content']")
    WebElement modalCollectionPoint;


    //indirim kuponlarım butonu.
    @FindBy(xpath = "//div[@id='headerMain']/div[1]/div/ul/li[1]/a")
    WebElement btnDiscountCoupons;


    //Account icerisindeki;Giriş yap ve üye ol, tab pathleri.
    @FindBy(css = "button.tab.left")
    WebElement btnLogin;
    @FindBy(css = "button.tab.right")
    WebElement btnSignUp;

    //Kullanıcı bilgileri.
    @FindBy(xpath = "//input[@data-testid='email-input']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@data-testid='password-input']")
    WebElement inputPassword;

    //Cinsiyet tercihi.
    @FindBy(css = "button.male")
    WebElement btnMale;
    @FindBy(css = "button.female")
    WebElement btnFemale;

    //üye ol sayfasındaki; checkboxlar.
    @FindBy(css = "div.marketing-checkbox .ty-check")
    WebElement btnCampaignCheckBox;
    @FindBy(css = "div.personal-checkbox .ty-check")//Burada name boş, FrontEnd tarafından eklenmeli.
    WebElement btnKvkkCheckBox;

    //üye ol butonu
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    WebElement btnRegisterSubmit;
    //Giriş yap butonu
    @FindBy(xpath = "//button[contains(@class, 'button submit')]")
    WebElement btnLoginSubmit;


    //Üye olmak için gerekli verileri doldurduktan sonra acılan modal.
    @FindBy(xpath = "//div[@class='email-verify-modal']")
    WebElement emailVerify;
    @FindBy(css = ".link.account-user")
    WebElement textUserContent;


    //Burada constructor oluşturduk ; Web element FindyBy ile oluşturulan webelementleri initialize(başlatmak) oluyor.(eşittir yapmamak gibi.)
    public TrendyoLoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    /**
     * @param addUrlPlugin : /payment, /account  gibi sayfalara direkt gitmek için kullanılabilir.
     * @return
     */
    public TrendyoLoginPage navigateToUrl(String addUrlPlugin) {
        DriverManager.getDriver().get("https://www.trendyol.com/" + addUrlPlugin);
        Log.pass("Trendyol Web sitesi açıldı.");
        btnClosePopUp.click();
        Log.pass("Trendyol Web sitesindeki karşılama modalı kapatıldı.");
        return this;
    }

    /**
     * @param chooseFields; Dört seçenekten bir tanesini seçtirmek için gerekli value.
     * @girisyap : User ikonunun bulundugu ; Giriş yap butonu.
     * @favorilerim : Kalp ikonlu favorilerim butonu.
     * @sepetim : Header bölgesindeki sepet ikonlu sepetim.
     * @indirimkuponlarım :Sayfanın en üst kısmında bulunan inidirim kuponlarım butonu.
     */
    public void chooseWayForLoginRegister(String chooseFields) throws InterruptedException {

        switch (chooseFields) {
            case "girisyap":
                btnUserLogin.click();
                Log.pass("HomePage'teki giriş yap ikonuna tıklandı.");
                break;

            case "favorilerim":
                btnFovorites.click();
                Log.pass("HomePage'teki Favorilerim ikonuna tıklandı.");
                break;

            case "sepetim":
                btnShopCart.click();
                Log.pass("HomePage'teki Sepetim ikonuna tıklandı.");
                if (!control == true) {
                    addProductInBasket();
                } else {
                    addProductInBasket();
                    userData(GetData.TRENDYOL_LOGIN_DATA.EMAIL.value, GetData.TRENDYOL_LOGIN_DATA.PASSWORD.value);
                    btnLoginSubmit.click();
                    Log.pass("Login olundu.");
                }
                break;

            case "indirimkuponlarım":
                btnDiscountCoupons.click();
                Log.pass("HomePage'teki Indirin Kuponlarım ikonuna tıklandı.");

                break;
            default:
                Log.fail("Girilen Value hatalıdır.");
                break;
        }
    }

    public void addProductInBasket() throws InterruptedException {

        chooseProduct.click();
        Log.pass("Ürün'ü sepete eklemek için sayfaya gidildi.");
        Thread.sleep(3000);
        switchToWindow();
        Log.pass("Yeni açılan pencerede aktif işlem yapılabilir.");
        addToBasket.click();
        Log.pass("Ürün sepete eklendi.");
        btnShopCart.click();
        Log.pass("Sepetin içerisine girildi.");
        btnShopCartToApprove.click();
        Log.pass("Sepetim sayfasında; Sepeti onayla butonuna tıklandı.");

    }


    public TrendyoLoginPage btnRegister(String chooseWayForRegister) throws InterruptedException {
        chooseWayForLoginRegister(chooseWayForRegister);
        btnSignUp.click();
        Log.pass("Üye ol tabına tıklandı.");
        return this;
    }

    boolean control = false;

    public TrendyoLoginPage btnLogin(String chooseWayForRegister) throws InterruptedException {
        chooseWayForLoginRegister(chooseWayForRegister);
        btnLogin.click();
        Log.pass("Giriş yap tabına tıklandı.");
        return this;
    }

    public TrendyoLoginPage btnLoginForCart(String chooseWayForRegister) throws InterruptedException {
        control = true;
        chooseWayForLoginRegister(chooseWayForRegister);
        return this;
    }

    public TrendyoLoginPage btnMyFavorites() {

        btnFovorites.click();
        Log.pass("HomePage'teki giriş yap ikonuna tıklandı.");
        btnSignUp.click();
        Log.pass("Üye ol tabına tıklandı.");


        return this;
    }

    public void userData(String email, String password) {
        inputEmail.sendKeys(email);
        Log.pass("Email adresi girildi: " + email);
        inputPassword.sendKeys(password);
        Log.pass("Şifre girildi : " + password);

    }

    //üye olurken işaretlenmesi gereken checkboxlar.
    public void necessaryCheckBox() {

        btnCampaignCheckBox.click();
        Log.pass("Kampayalar checkBox'ı true yapıldı.");
        btnKvkkCheckBox.click();
        Log.pass("KVKK checkBox'ı true yapıldı.");
    }

    public TrendyoLoginPage registerCustomer(String email, String password) throws InterruptedException {

        userData(email, password);
        btnFemale.click();
        Log.pass("Kadın cinsiyeti seçildi.");
        necessaryCheckBox();
        btnRegisterSubmit.click();
        Log.pass("Üye ol butonuna tıklandı.");
        Thread.sleep(3000);
        Log.pass("Üye ol butonuna bastıktan sonra açılan modal: " + emailVerify.getText());
        return this;
    }

    public TrendyoLoginPage loginCustomer(String email, String password) throws InterruptedException {

        userData(email, password);
        btnLoginSubmit.click();
        Log.pass("Üye ol butonuna tıklandı.");
        Thread.sleep(3000);
        Log.pass("Üye ol butonuna bastıktan sonra açılan modal: " + textUserContent.getText());
        return this;
    }


}
