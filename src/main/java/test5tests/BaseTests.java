package test5tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test5pages.*;

import java.time.Duration;

public abstract class BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;

    private CartPage cartPage;
    private ChackoutPage chackoutPage;
    private HomePage homePage;
    private ProductsPage productsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mila-\\Desktop\\EXE file\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cartPage = new CartPage(driver, driverWait);
        chackoutPage = new ChackoutPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        productsPage = new ProductsPage(driver, driverWait);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");


    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public ChackoutPage getChackoutPage() {
        return chackoutPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }
    //    public WebDriver getDriver() {
//        return driver;
//    }
//
//    public HomePage getHomePage() {
//        return homePage;
//    }

}
