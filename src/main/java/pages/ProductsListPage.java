package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webDriver.WebDriverSingleton;

import java.util.List;

public class ProductsListPage extends BasePage {
    private WebDriver driver;

    public ProductsListPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    private By newConditionFilter = By.xpath("//li/span[contains(.,'New')]");
    private By freeShippingFilter = By.id("apb-browse-refinements-checkbox_0");
    private By sortDropDown = By.id("s-result-sort-select");
    private By productsListItems = By.xpath("//div[contains(@role, 'listitem')]");
    private By lastProductOnThePAge = By.xpath("//div[contains(@role, 'listitem')][16]");
    private By nextPageButton = By.cssSelector("a.s-pagination-next");
    private By cartIcon = By.id("nav-cart");
    private By cartCount = By.id("nav-cart-count");
    private String priceLocator = "//div[contains(@role, 'listitem')][%s]//span[contains(@class, 'a-price-whole')]";
    private String addToCartDynamicLocator = "//div[contains(@role, 'listitem')][%s]//button[contains(@aria-label, 'Add to cart')]";


    public void sortPriceHighToLow() {
        selectFromDropdownByValue(sortDropDown, "price-desc-rank");
    }

    public void filterByFreeShipping() {
        scrollIntoView(freeShippingFilter);
        clickByJs(freeShippingFilter);
    }

    public void filterByConditionNew() {
        scrollIntoView(newConditionFilter);
        click(newConditionFilter);
    }
    public CartSummary addItemsBelowThresholdToCart(Integer threshold) {
        wait(lastProductOnThePAge);
        List<WebElement> productsList = driver.findElements(productsListItems);
        int countOfItems = 0;
        Integer itemPrice;
        Integer totalPrice = 0;
        String priceText;
        for(int itemCounter = 0; itemCounter< productsList.size(); itemCounter++){
            try{
                By price = By.xpath(String.format(priceLocator, itemCounter+1));
                priceText = driver.findElement(price).getText()
                        .replaceAll("[^0-9]", "");
                if (!priceText.isEmpty()) {
                    itemPrice = Integer.parseInt(priceText);
                } else {
                    continue;
                }

                if (itemPrice < threshold) {
                    By addToCartLocator = By.xpath(String.format(addToCartDynamicLocator, itemCounter+1));
                    WebElement addToCartBtn = driver.findElement(addToCartLocator);

                    scrollIntoView(addToCartBtn);
                    wait(addToCartLocator);
                    clickByJs(addToCartBtn);

                    totalPrice+=itemPrice;
                    countOfItems++;
                    wait.until(ExpectedConditions.textToBe(cartCount,String.valueOf(countOfItems)));

                }
            }catch (Exception e) {
                continue;
            }
        }

        if(countOfItems == 0) {
            click(nextPageButton);
            addItemsBelowThresholdToCart(threshold);
        }
        return new CartSummary(countOfItems, totalPrice);
    }

    public CartPage navigateToCart() {
        scrollIntoView(cartIcon);
        clickByJs(cartIcon);
        return new CartPage();
    }

    public static class CartSummary {
        private int itemCount;
        private int totalPrice;

        public CartSummary(int itemCount, int totalPrice) {
            this.itemCount = itemCount;
            this.totalPrice = totalPrice;
        }

        public int getItemCount() {
            return itemCount;
        }

        public int getTotalPrice() {
            return totalPrice;
        }
    }

}
