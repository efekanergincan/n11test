package com.n11.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavouritePage extends BasePage {

    // 3.ürünün favori ekle butonu
    @FindBy(xpath = "//*[@id=\"p-437355132\"]/div[1]/span")
    private WebElement favoriPopupButton;

    // Favori listesi
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]")
    private WebElement liste;

    // Ürün listeleri
    @FindBy(xpath = "//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a/h4")
    private List<WebElement> urunlistesi;

    // Ürün silme butonu
    @FindBy(xpath = "//*[@id=\"p-437355132\"]/div[3]/span")
    private WebElement urunsil;

    @FindBy(className = "message")
    private WebElement message;

    @FindBy(className = "closeBtn")
    private WebElement closeBtn;

    public FavouritePage(WebDriver driver) {
        super(driver);
    }

    // 3.Pop-up kısmından favorileri seç
    public void clickPopupMyFavorite() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", favoriPopupButton);
        waitForPageLoad();
    }


    public void favoriliste() {
        liste.click();
        waitForPageLoad();
    }


    public List<WebElement> favorilisteleme() {
        return urunlistesi;
    }


    public void urunsilme() {
        urunsil.click();
    }

    public String getMessage() {
        return message.getText();
    }


    public void closeContent() {
        closeBtn.click();
        waitForPageLoad();
    }
}
