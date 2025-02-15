package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.WebDriverSingleton;

public class CartPage extends BasePage {
    private WebDriver driver;

    public CartPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    private By cartItemsList = By.className("sc-list-item-content");
    private By checkOutButton = By.name("proceedToRetailCheckout");
    private By totalAmount = By.id("sc-subtotal-amount-buybox");

    public int getCountOfCartItems() {
        return getWebElementsListSize(cartItemsList);
    }

    public CheckOutPage navigateToCheckOut() {
        click(checkOutButton);
        return new CheckOutPage();
    }

    public int getTotalCartAmount() {
        return Integer.parseInt(driver.findElement(totalAmount).getText()
                .replaceAll("[^0-9]", ""))/100;
    }

}
