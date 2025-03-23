package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends BaseTest {
    @Test
    @Parameters({"username", "password"})
    public void checkOut(String username, String password) {
        //using the loginPage to access...
        LoginPage loginpage = new LoginPage();
        //used saved in testng parameters of username and password
        loginpage.login(username, password);

        //Checking with boolean if login is successful
        loginpage.logInIsSuccessful();

        ProductsPage productsPage = new ProductsPage();
        productsPage.addProductsToCart();

        productsPage.userIsInCart();

        CartPage cartPage = new CartPage();
        cartPage.goToCheckout();

        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.fillCheckout("Yana", "Itani", "2511GC");

        checkOutPage.userIsInCheckoutOverview();

        CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage();

        Assert.assertTrue(checkOutOverviewPage.validateTotalPrice());

        checkOutOverviewPage.finalizeOrder();

        Assert.assertTrue(checkOutOverviewPage.wasOrderSuccessful());


        }
    }


