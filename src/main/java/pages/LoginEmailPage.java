package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.WebDriverSingleton;

public class LoginEmailPage extends BasePage {
    private WebDriver driver;
    private String email = getProperty("email");
    private By emailInputField = By.name("email");
    private By continueButton = By.id("continue");
    public LoginEmailPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public LoginPasswordPage enterEmail() {
        type(emailInputField, email);
        click(continueButton);
        return new LoginPasswordPage();
    }
}
