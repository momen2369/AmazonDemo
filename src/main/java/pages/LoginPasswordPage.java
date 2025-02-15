package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.WebDriverSingleton;


public class LoginPasswordPage extends BasePage {
    private WebDriver driver;
    private String pass = getProperty("password");
    private By passwordInputField = By.name("password");
    private By signInButton = By.id("signInSubmit");
    public LoginPasswordPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public HomePage enterPassword() {
        click(passwordInputField);
        type(passwordInputField, pass);
        clickByJs(signInButton);

        return new HomePage();
    }

}
