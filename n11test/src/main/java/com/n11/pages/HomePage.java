package com.n11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage  {


    @FindBy(className = "btnSignIn")
    private WebElement girisyap;

    @FindBy(id = "loginButton")
    private  WebElement  oturumac;

    //N11 BİLDİRİMİNİ KAPAMA
    @FindBy(className = "dn-slide-deny-btn")
    private WebElement deny;

    //ÇIKAN KVKK BİLDİRİMİNİ KAPAMA
    @FindBy(className = "closeBtn")
    private WebElement cls;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void OturumAcmaSayfasi(){
        girisyap.click();
        wait.until(elementClickableById(oturumac));
    }
    public String site(){
        return "https://www.n11.com/";
    }

    //KVKK kapama
    public void KVKK(){
        cls.click();
    }

    //Hatırlat ikonu kapama
    public void BildirimKapama(){
        deny.click();

    }
}
