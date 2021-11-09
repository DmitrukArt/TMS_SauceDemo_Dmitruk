import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemo extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUpSauce() {
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void positiveLogIn() {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        String userNameFieldResult = driver.findElement(By.xpath("//input[@value='standard_user']")).getAttribute("value");
        Assert.assertEquals(userNameFieldResult,"standard_user", "The password must be entered");
        String passwordFieldResult = driver.findElement(By.xpath("//input[@value='secret_sauce']")).getAttribute("value");
        Assert.assertEquals(passwordFieldResult, "secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();
    }
    @Test
    public void addingRemovingBuyingItems() {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();
        WebElement sauceLabsBackpack = driver.findElement(By.id("item_4_title_link"));
        sauceLabsBackpack.click();
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        WebElement numberOfItems = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span"));
        Assert.assertEquals(numberOfItems.getText(),"1");
        WebElement backToProducts = driver.findElement(By.className("left_component"));
        backToProducts.click();
        WebElement addButton = driver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-bike-light']"));
        addButton.click();
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
        WebElement removeItem = driver.findElement(By.cssSelector("#remove-sauce-labs-bike-light"));
        removeItem.click();
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id='checkout']"));
        checkoutButton.click();
        WebElement firstNameField = driver.findElement(By.cssSelector("[name='firstName']"));
        firstNameField.sendKeys("Artyom");
        WebElement lastNameField = driver.findElement(By.cssSelector("[name='lastName']"));
        lastNameField.sendKeys("Dmitruk");
        WebElement zipCodeField = driver.findElement(By.cssSelector("[name='postalCode']"));
        zipCodeField.sendKeys("666666");
        WebElement continueButton = driver.findElement(By.cssSelector("[type='submit'"));
        continueButton.click();
        WebElement paymentInfo = driver.findElement(By.xpath("//*[@class='summary_info']/child::div[2]"));
        Assert.assertTrue(paymentInfo.isDisplayed(),"Payment info must be displayed");
        WebElement shippingInfo = driver.findElement(By.xpath("//*[@class='summary_info']/child::div[2]"));
        Assert.assertTrue(shippingInfo.isDisplayed(),"Message should be displayed");
        //WebElement totalCost = driver.findElement(By.xpath("//*[@class='summary_info']/child::div[7]/text()[2]"));    Уточнить, локатор правильный, не находит
        WebElement finishButton = driver.findElement(By.xpath("//*[@id='finish']"));
        finishButton.click();
        WebElement finalMessage = driver.findElement(By.xpath("//*[@class='complete-text']"));
        Assert.assertEquals(finalMessage.getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");



    }
}
