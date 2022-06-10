package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{
    //Dodavanje jednog proizvoda(po izboru) u korpu i provera da li je proizvod dodat
    //id svakog add to cart btn -a je drugaciji jupii
    private By addToCardBtnFirstAdd = By.id("add-to-cart-sauce-labs-backpack");
    private By cartItemIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private By cartBtn = By.xpath("//*[@id=\"shopping_cart_container\"]/a");


    public ProductsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
//    public WebElement getAnyAdd (String addName){
//        return getDriver().findElement(By.linkText(addName));
//    }
//    public void openAnyAdd (String addName){
//        getAnyAdd(addName).click();
//
//    }

    public WebElement getAddToCardBtnFirstAdd() {
        return getDriver().findElement(addToCardBtnFirstAdd);
    }
    public void clickaAddToCartBtn(){
        getAddToCardBtnFirstAdd().click();
    }
    public WebElement getCartIcon() {
        return getDriver().findElement(cartItemIcon);
    }
    public WebElement getCartBtn() {
        return getDriver().findElement(cartBtn);
    }

    public void clickGoToCartBtn(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(cartItemIcon));
        getCartBtn().click();
    }

}
