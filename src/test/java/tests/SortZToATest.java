package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SortZToATest extends BaseTest{
    @Test
    @Parameters({"username", "password"})
    public void sortZtoA(String username, String password) {

        //using the loginPage to access...
        LoginPage loginpage = new LoginPage();
        //used saved in testng parameters of username and password
        loginpage.login(username, password);

        //Checking with boolean if login is successful
        Assert.assertTrue(loginpage.logInIsSuccessful());

        ProductsPage productsPage = new ProductsPage();
        productsPage.sortFromZtoA();

        Assert.assertTrue(productsPage.productsSortedFromZtoA());
    }
}
