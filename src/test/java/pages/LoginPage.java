package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.DriverProvider.*;

public class LoginPage {
    private String usernameId = "user-name";
    private String xPathPasswordId = "password";
    private String submitBtnId = "login-button";
    private String burgerBtnId = "react-burger-menu-btn";
    private String loginFailedErrorXpath = "//div[@class='error-message-container error']";

    public void login(String login, String password){
        WebElement userName = findElement(By.id(usernameId));
        userName.sendKeys(login);

        WebElement password1 = findElement(By.id(xPathPasswordId));
        password1.sendKeys(password);

        WebElement submitButton = findElement(By.id(submitBtnId));
        submitButton.click();
    }
    public Boolean logInIsSuccessful() {
        getCurrentWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(burgerBtnId)));
        WebElement burgerButton = getCurrentDriver().findElement(By.id(burgerBtnId));
        if (burgerButton.isDisplayed()) {
            return true;
        } else {
            return false;

        }
    }

    public Boolean loginFailed(){
        WebElement failedLoginErrorMessage = findElement(By.xpath(loginFailedErrorXpath));

        if(failedLoginErrorMessage.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

}
