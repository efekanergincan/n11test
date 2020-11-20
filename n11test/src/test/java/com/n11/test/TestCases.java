package com.n11.test;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import com.n11.pages.FavouritePage;
import com.n11.pages.HomePage;
import com.n11.pages.LoginPage;
import com.n11.pages.SearchPage;

import static java.util.concurrent.TimeUnit.SECONDS;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases  extends  BaseTest{

    //Anasayfaya giriş ve kontrol
    @Test
    public void test_1_1_Anasayfa() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site());
        driver.manage().window().maximize();
        homePage.waitForPageLoad();
        homePage.KVKK();//KVKK Kapanır
        Thread.sleep(7000);//Hatırlatma bildirimi bekleme süresi
        homePage.BildirimKapama();//Hatırlatma kapanır
        System.out.println("title ="+driver.getTitle());
        Assert.assertEquals("n11.com - Hayat Sana Gelir", driver.getTitle());
        System.out.println("N11 Alışveriş sitesi başarılı bir şekilde açıldı");
    }

    //Kullanıcı giriş sayfası
    @Test
    public void test_1_2_login(){
        HomePage homePage=new HomePage(driver);
        homePage.OturumAcmaSayfasi();
    }

    //Oturum Açma
    @Test
    public void test_1_3_OturumAcma() {
        LoginPage loginPage =new LoginPage(driver);
        loginPage.KullaniciGirme("efekanergincan95@gmail.com", "1234efe1234");
        loginPage.gonder();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(400, SECONDS);

        loginPage.waitForPageLoad();

    }

    //Arama Yapma
    @Test
    public void test_1_4_aramayapma () throws InterruptedException{

        SearchPage searchPage =new SearchPage(driver);
        searchPage.aramagirisi("samsung");
        searchPage.aramayap();
        Thread.sleep(100);
        Assert.assertNotEquals(" ", searchPage.aramasonucu());
        System.out.println("Samsung için sonuç bulundu");

    }


    //2. sayfaya giriş
    @Test
    public void test_1_5_ikincisayfa () throws InterruptedException{
        Thread.sleep(200);
        SearchPage searchPage =new SearchPage(driver);
        searchPage.ikincisayfayatiklama();
        searchPage.waitForPageLoad();
        Assert.assertTrue(driver.getTitle().contains("Samsung - n11.com - 2/"));
        System.out.println("2. Sayfa başarılı bir şekilde açıldı...");

    }

    //3. ürünü seçme
    @Test
    public void test_1_6_urun3favorilereekleme (){
        SearchPage searchPage =new SearchPage(driver);
        searchPage.urunsecme();
        searchPage.favorilereekle();
        System.out.println("Favoriye Eklenen Ürün   : "+searchPage.getSecilenFavoriUrun());

    }

    //Favori hesap sayfası
    @Test
    public void test_1_7_favorilerim () {
        FavouritePage favouritePage =new FavouritePage(driver);
        favouritePage.clickPopupMyFavorite();
        System.out.println("Favoriler için hesap sayfası başarılı bir şekilde açıldı...");

    }

    //Favorilerim sayfası
    @Test
    public void test_1_8_favorilistesi () {
        FavouritePage favouritePage =new FavouritePage(driver);
        favouritePage.favoriliste();
        System.out.println("Favorilerim sayfası başarılı bir şekilde açıldı...");

    }

    //Ürünün onaylanması
    @Test
    public void test_1_9_Favoriyeklenenurun () {
        FavouritePage favouritePage =new FavouritePage(driver);
        for (WebElement productTitle : favouritePage.favorilisteleme()) {
            String watchesProduct=productTitle.getText();
            if (watchesProduct.equals(favouritePage.getSecilenFavoriUrun())) {
                System.out.println("Favoriye Eklenen Ürün Onaylandı.Ürün :"+watchesProduct+"\n");
                Assert.assertEquals(watchesProduct, favouritePage.getSecilenFavoriUrun());
            }
        }
    }

    //Ürün silme
    @Test
    public void test_2_1_urunsilme () throws InterruptedException {
        FavouritePage favouritePage =new FavouritePage(driver);
        for (WebElement productTitle : favouritePage.favorilisteleme()) {
            String watchesProduct=productTitle.getText();
            if (watchesProduct.equals(favouritePage.getSecilenFavoriUrun())) {
                favouritePage.urunsilme();
                Thread.sleep(3000);
                Assert.assertEquals("Ürününüz listeden silindi.", favouritePage.getMessage());
                favouritePage.closeContent();
                System.out.println("Ürününüz listeden başarılı bir şekilde silindi.");

            }
        }
    }

    //Ürün silme onay
    @Test
    public void test_2_2_urunsilmeonayi () {
        boolean kontrol=true;
        FavouritePage favouritePage =new FavouritePage(driver);
        for (WebElement productTitle : favouritePage.favorilisteleme()) {
            String izlenenurunler=productTitle.getText();
            if (izlenenurunler.equals(favouritePage.getSecilenFavoriUrun()))
                kontrol=false;
        }
        Assert.assertFalse(kontrol);
        System.out.println("Ürününüz favorilerde yer almıyor.");

    }

}

