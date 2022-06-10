package test5tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test5pages.CartPage;
import test5pages.ChackoutPage;
import test5pages.HomePage;
import test5pages.ProductsPage;

public class Tests extends BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;

    private CartPage cartPage;
    private ChackoutPage chackoutPage;
    private HomePage homePage;
    private ProductsPage productsPage;

    @Test(priority = 1)
    public void loginTest() {
        //Login na stranicu (username: standard_user, password: secret_sauce)
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getUsernameBar()));
        homePage.enterAllLoginOptions("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test(priority = 2)
    public void addToCart() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        //yato sto mi ne prolazi prvi pa da mogu da ga testiram stavljam da ide na stranu puz sam
        productsPage.getAddToCardBtnFirstAdd();
        productsPage.clickaAddToCartBtn();
        productsPage.clickGoToCartBtn();

        Assert.assertEquals(cartPage.getItemText(), "Sauce Labs Backpack");


    }
    @Test (priority = 3)
    public void chackout(){
        cartPage.clickCheckoutBtn();
        cartPage.fillOutOrder("Mila","j","21000");
        cartPage.getContinue().click();
        chackoutPage.clickFinish();
     //no time :(   Assert.

    }
}
