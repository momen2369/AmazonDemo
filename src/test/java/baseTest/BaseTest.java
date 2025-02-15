package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import webDriver.WebDriverSingleton;

public class BaseTest {

    private WebDriver driver = WebDriverSingleton.getDriver();
    protected HomePage homePage = new HomePage();


    @BeforeMethod
    public void openHomePage() {
        driver.get("https://www.amazon.eg/");
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
