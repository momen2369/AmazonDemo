package pages;

import org.openqa.selenium.WebDriver;
import webDriver.WebDriverSingleton;

public class CheckOutPage {
    private WebDriver driver;

    public CheckOutPage() {
        this.driver = WebDriverSingleton.getDriver();
    }
}
