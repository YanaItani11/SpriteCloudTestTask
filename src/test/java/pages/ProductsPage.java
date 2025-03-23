package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.DriverProvider.*;

public class ProductsPage {
    private String backpackAddToCartXpath = "//button[@data-test = 'add-to-cart-sauce-labs-backpack']";
    private String onesieAddToCartXpath = "//button[@data-test = 'add-to-cart-sauce-labs-onesie']";
    private String shoppingCartXpath = "//a[@data-test = 'shopping-cart-link']";
    private String checkoutBtnId = "checkout";
    private String productSortContainerXpath = "//select[@data-test = 'product-sort-container']";
    private String optionValueZtoAXpath = "//option[@value = 'za']";

    private String productTitleXpath = "//div[@data-test = 'inventory-item-name']";

    public void addProductsToCart(){
        WebElement addToCartBackpack = findElement(By.xpath(backpackAddToCartXpath));
        addToCartBackpack.click();

        WebElement addToCartOnesie = findElement(By.xpath(onesieAddToCartXpath));
        addToCartOnesie.click();

        WebElement shoppingCart = findElement(By.xpath(shoppingCartXpath));
        shoppingCart.click();
    }

    public Boolean userIsInCart(){
        WebElement checkOutBtn = getCurrentDriver().findElement(By.id(checkoutBtnId));
        if (checkOutBtn.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void sortFromZtoA(){
        WebElement productSortContainer = findElement(By.xpath(productSortContainerXpath));
        productSortContainer.click();

        WebElement optionValueZtoA = findElement(By.xpath(optionValueZtoAXpath));
        optionValueZtoA.click();
    }

    public Boolean productsSortedFromZtoA(){
        List<WebElement> productTitles = getCurrentDriver().findElements(By.xpath(productTitleXpath));
        for (int i = 0; i < productTitles.size() - 1; i++) {
            if (productTitles.get(i).getText().compareTo(productTitles.get(i + 1).getText()) < 0) {
                return false; // Not sorted in descending order
            }
        }
        return  true;
    }

}
