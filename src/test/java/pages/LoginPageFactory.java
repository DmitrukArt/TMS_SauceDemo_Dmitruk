package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPageFactory extends BasePage {

    @FindBy(id = "user-name")       //driver.findElement(By.id("myId")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    private WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

   // public void open() {
   //     driver.get(URL);
   // }


    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
