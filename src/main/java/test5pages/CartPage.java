package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
    private By itemInCard = By.id("item_4_title_link");
    private By chackoutBtn = By.id("checkout");
    private By firstNameBar = By.id("first-name");
    private By lastNameBar = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueBtn = By.id("continue");


    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getItemInCard() {
        return getDriver().findElement(itemInCard);
    }

    public String getItemText() {
        return getItemInCard().getText();

    }

    public WebElement getChackoutBtn() {
        return getDriver().findElement(chackoutBtn);
    }

    public void clickCheckoutBtn() {
        getChackoutBtn().click();
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstNameBar);
    }

    public WebElement getLastName() {
        return getDriver().findElement(lastNameBar);
    }

    public WebElement getZipCode() {
        return getDriver().findElement(zipCode);
    }

    public WebElement getContinue() {
        return getDriver().findElement(continueBtn);

    }

    public void fillOutOrder(String firstName, String lastName, String zip) {
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getZipCode().sendKeys(zip);
        getDriverWait().until(ExpectedConditions.elementToBeClickable(getContinue()));
        getContinue().click();
    }

}
