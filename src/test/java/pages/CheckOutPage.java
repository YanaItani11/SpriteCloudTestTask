package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.DriverProvider.*;

public class CheckOutPage {
    private String checkoutFirstNameFieldId = "first-name";
    private String checkoutLastNameFieldId = "last-name";
    private String checkoutZipCodeFieldId =  "postal-code";
    private String continueBtnId =  "continue";
    private String finishBtnId =  "finish";


    public void fillCheckout(String firstName, String lastName, String postalCode) {
        getCurrentWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(checkoutFirstNameFieldId)));

        WebElement firstNameElement = findElement(By.id(checkoutFirstNameFieldId));
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = findElement(By.id(checkoutLastNameFieldId));
        lastNameElement.sendKeys(lastName);

        WebElement postalCodeElement = findElement(By.id(checkoutZipCodeFieldId));
        postalCodeElement.sendKeys(postalCode);

        WebElement continueBtnElement = findElement(By.id(continueBtnId));
        continueBtnElement.click();
    }

    public Boolean userIsInCheckoutOverview(){
        WebElement finishBtn = getCurrentDriver().findElement(By.id(finishBtnId));
        if (finishBtn.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

}
