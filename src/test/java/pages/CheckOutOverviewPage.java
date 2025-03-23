package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static utils.DriverProvider.*;

public class CheckOutOverviewPage {
    private String itemPriceXpath = "//div[@data-test ='inventory-item-price']";
    private String subTotalXpath = "//div[@data-test='subtotal-label']";
    private String taxXpath = "//div[@data-test='tax-label']";
    private String totalXpath = "//div[@data-test='total-label']";
    private String finishBtnId = "finish";
    private String completeHeaderXpath = "//h2[@data-test='complete-header']";

    public Boolean validateTotalPrice(){
        List<WebElement> items = getCurrentDriver().findElements(By.xpath(itemPriceXpath));
        float sum = 0;
        for(int i =0; i <items.size(); i++) {
            String price = items.get(i).getText().replace("$","");
            sum += Float.parseFloat(price);
        }

        WebElement subTotalElm = getCurrentDriver().findElement(By.xpath(subTotalXpath));
        JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
        String subTotalStr = (String) js.executeScript(
                "return arguments[0].childNodes[1].textContent.trim();", subTotalElm);

        float subTotal = Float.parseFloat(subTotalStr);

        if(subTotal != sum){
            return false;
        }

        WebElement taxElm = getCurrentDriver().findElement(By.xpath(taxXpath));
        String taxStr = (String) js.executeScript(
                "return arguments[0].childNodes[1].textContent.trim();", taxElm);
        float tax = Float.parseFloat(taxStr);

        WebElement totalElm = getCurrentDriver().findElement(By.xpath(totalXpath));
        String totalStr = (String) js.executeScript(
                "return arguments[0].childNodes[1].textContent.trim();", totalElm);
        float total = Float.parseFloat(totalStr);
        float calculatedTotal =tax + subTotal;

        return total == calculatedTotal;
    }

    public void finalizeOrder() {
        WebElement finishBtn = getCurrentDriver().findElement(By.id(finishBtnId));
        finishBtn.click();
    }

    public Boolean wasOrderSuccessful() {
        getCurrentWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(completeHeaderXpath)));
        WebElement completeHeader = findElement(By.xpath(completeHeaderXpath));
        if(completeHeader.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }


}
