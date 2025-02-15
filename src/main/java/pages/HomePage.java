package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.WebDriverSingleton;

public class HomePage extends BasePage {
    private WebDriver driver;
    private By loginButton = By.id("nav-link-accountList");
    private By allMenuButton = By.id("nav-hamburger-menu");
    private By seeAllButton = By.xpath("//a[contains(@aria-label, 'See All Categories')]");
    private By videoGamesOption = By.xpath("//a[contains(@data-menu-id, '16') and contains(.,'Video Games')]");
    private By allVideoGamesOption = By.xpath("//a[contains(@class, 'hmenu-item') and contains(.,'All Video Games')]");
    public HomePage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public LoginEmailPage clickLoginButton() {
        click(loginButton);
        return new LoginEmailPage();
    }

    public boolean isDisplayed() {
        wait(loginButton);
        return driver.findElement(loginButton).isDisplayed();
    }

    public void openAllMenu() {
        click(allMenuButton);
    }

    public void clickSeeAllInSideMenu() {
        click(seeAllButton);
    }

    public void clickVideoGamesInSideMenu() {
        scrollIntoView(videoGamesOption);
        clickByJs(videoGamesOption);
    }

    public ProductsListPage clickAllVideoGamesInSideMenu() {
        clickByJs(allVideoGamesOption);
        return new ProductsListPage();
    }


}
