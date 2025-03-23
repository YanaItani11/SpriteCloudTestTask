package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static utils.DriverProvider.getCurrentDriver;
import static utils.DriverProvider.quitCurrentDriver;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        getCurrentDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        quitCurrentDriver();
    }
}


