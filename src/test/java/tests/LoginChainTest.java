package tests;

import org.testng.annotations.AfterMethod;

public class LoginChainTest extends BaseTest{
    @AfterMethod(alwaysRun = true)
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}
