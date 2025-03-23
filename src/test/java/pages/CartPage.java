package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.findElement;

public class CartPage {
    private String checkoutBtnId = "checkout";

    public void goToCheckout() {
        WebElement checkoutBtnElement = findElement(By.id(checkoutBtnId));
        checkoutBtnElement.click();
    }
}
