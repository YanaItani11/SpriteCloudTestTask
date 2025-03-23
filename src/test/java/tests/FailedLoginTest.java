package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTest extends BaseTest{
    @Test
    @Parameters({"username", "wrongPassword"})
    public void failingLogin(String username, String wrongPassword) {

        //using the loginPage to access...
        LoginPage loginpage = new LoginPage();
        //used saved in testng parameters of username and password
        loginpage.login(username, wrongPassword);

        //Checking with boolean if login is successful
        Assert.assertTrue(loginpage.loginFailed());
    }
}
