package com.n11.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
    private static String secilenfavoriurun;
    WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait= new WebDriverWait(this.driver , 500);
        PageFactory.initElements(driver, this);
    }
    public ExpectedCondition<WebElement> elementClickableById(WebElement element){
        return ExpectedConditions.elementToBeClickable(element);
    }
    public ExpectedCondition<WebElement>  elementClickableByXpad(WebElement element) {
        return ExpectedConditions.elementToBeClickable((element));
    }

    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(driver -> {
            assert driver != null;
            System.out.println("Current Window State       : "
                    + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }

    public String getSecilenFavoriUrun(){
        return secilenfavoriurun;
    }
    public void setSecilenFavoriUrun(String selectedFavoriteProduct){
        BasePage.secilenfavoriurun =selectedFavoriteProduct;
    }



}
