package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChackoutPage extends BasePage {
    private By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By finishBtn = By.id("finish");
    private By tnxMessage = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private By menuBtn = By.id("react-burger-menu-btn");

    public ChackoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getTotal() {
        return getDriver().findElement(total);
    }

    public WebElement getFinishBtn() {
        return getDriver().findElement(finishBtn);
    }

    public void clickFinish() {
        getFinishBtn().click();

    }
    public String getMessageTxt (){
        //mogla sam i get metodu pravit but time is of teh essence
        return getDriver().findElement(tnxMessage).getText();

    }
    public WebElement getMenuBtn() {
        return getDriver().findElement(menuBtn);
    }

    public void clickMenu (){
        getMenuBtn().click();

    }
    public void selectMenuOptions(String menuOptions){
        Select select = new Select(getMenuBtn());
        select.selectByVisibleText(menuOptions);
    }
}
