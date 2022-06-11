package test5tests;

import org.checkerframework.checker.units.qual.A;
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


    @Test(priority = 1)
    public void loginTest() {
        //Login na stranicu (username: standard_user, password: secret_sauce)
        getDriverWait().until(ExpectedConditions.elementToBeClickable(getHomePage().getUsernameBar()));
        getHomePage().enterAllLoginOptions("standard_user", "secret_sauce");

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test(priority = 2)
    public void addToCart() {

        getProductsPage().getAddToCardBtnFirstAdd();
        getProductsPage().clickaAddToCartBtn();
        getProductsPage().clickGoToCartBtn();

        Assert.assertEquals(getCartPage().getItemText(), "Sauce Labs Backpack");


    }

    @Test(priority = 3)
    public void chackout() {
        getCartPage().clickCheckoutBtn();
        getCartPage().fillOutOrder("Mila", "Jovic", "21000");
        Assert.assertTrue(getChackoutPage().getFinishBtn().isDisplayed());

    }

    @Test(priority = 4)
    public void confirmPurches() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(getChackoutPage().getTotal()));
        String actualResult = getChackoutPage().getTotalText();
        getChackoutPage().clickFinish();
        ;
        Assert.assertEquals(actualResult, "Total: $32.39");
        Assert.assertEquals(getChackoutPage().getMessageTxt(), "THANK YOU FOR YOUR ORDER");
    }

    @Test(priority = 5)
    public void logout() {
        getChackoutPage().clickMenu();
        getChackoutPage().clickManuLogoutOption();
        getHomePage().clickLiginBtn();
        String actualResult = getHomePage().errorrMsgText();
        Assert.assertEquals(actualResult, "Epic sadface: Username is required");

    }
}
