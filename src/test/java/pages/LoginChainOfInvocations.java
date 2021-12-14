package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginChainOfInvocations extends BasePage {

    /* @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    private WebElement errorMessage;
  */
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    public boolean isErrorMessageDisplayed(){
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public LoginChainOfInvocations(WebDriver driver) {
        super(driver);
    }

    public LoginChainOfInvocations open() {
        driver.get(URL);
        return this;
    }
    public ProductsPage login (String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    return new ProductsPage(driver);
    }
}
