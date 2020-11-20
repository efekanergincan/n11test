package com.n11.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage  extends BasePage{

    @FindBy(id = "searchData")
    private WebElement arama;

    @FindBy(xpath="//*[@class='searchBtn']")
    private WebElement aramabutonu;

    //Arama sonucu
    @FindBy(xpath = "//*[@class='resultText ']/strong")
    private WebElement aramasonucu;

    //Arama sayfasındaki 2.button
    @FindBy(xpath = "//*[@class='pagination']/a[2]")
    private WebElement ikincisayfa;

    //Arama sonuçlarından listedeki 3. ürün
    @FindBy(xpath = "//li[3]/div/div[2]/span[2]")
    private WebElement urun3;

    //3.ürün isimi
    @FindBy(xpath = "//li[3]/div/div/a/h3")
    private WebElement urunismi;

    //3.ürünün favori ekle buttonu
    @FindBy(xpath = "//li[3]/div/div[2]/span[2]")
    private WebElement favorilereekleme;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //Arama kısmına veri girmek için
    public void aramagirisi(String data) {
        this.arama.clear();
        this.arama.sendKeys(data);
    }

    //Arama yapmak için
    public void aramayap() {
        aramabutonu.click();
    }

    //Arama sonucu
    public String aramasonucu()
    {
        return aramasonucu.getText();
    }

    //Arama sayfasının 2. butonuna tıklanması
    public void ikincisayfayatiklama() {
        ikincisayfa.click();
    }

    //3.Ürünü seçme
    public void urunsecme(){
        wait.until(elementClickableByXpad(urun3));
        setSecilenFavoriUrun(urunismi.getText());
        favorilereekleme.click();
    }

    //Favorilere ekle
    public void favorilereekle(){
        favorilereekleme.click();
    }
}