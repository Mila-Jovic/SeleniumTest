package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    //Login na stranicu (username: standard_user, password: secret_sauce)
    private By usernameBar = By.id("user-name");
    private By passwordBar = By.id("password");
    private By loginBtn = By.id("login-button");
    private By loginErrorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getUsernameBar() {
        return getDriver().findElement(this.usernameBar);
    }

    public WebElement getPasswordBar() {
        return getDriver().findElement(passwordBar);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public void clickLiginBtn() {

        getLoginBtn().click();
    }


    public void enterAllLoginOptions (String username, String pass){
       getUsernameBar().sendKeys(username);
        getPasswordBar().sendKeys(pass);
        clickLiginBtn();
    }

    public WebElement getLoginErrorMsg() {
        return getDriver().findElement(this.loginErrorMsg);
    }
    public String errorrMsgText (){
        return getLoginErrorMsg().getText();
    }
}
