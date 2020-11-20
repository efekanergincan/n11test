package com.n11.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement sifre;

    @FindBy(id = "loginButton")
    private WebElement OturumAc;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Kullanıcı girişi
    public void KullaniciGirme(String email, String password) {
        this.email.clear();
        this.email.sendKeys(email);

        this.sifre.clear();
        this.sifre.sendKeys(password);
    }


    public void gonder() {

        OturumAc.click();

    }



}