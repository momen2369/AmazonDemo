package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkOutTest() {
        LoginEmailPage loginEmailPage = homePage.clickLoginButton();
        LoginPasswordPage loginPasswordPage = loginEmailPage.enterEmail();
        homePage = loginPasswordPage.enterPassword();
        Assert.assertTrue(homePage.isDisplayed());

        homePage.openAllMenu();
        homePage.clickSeeAllInSideMenu();
        homePage.clickVideoGamesInSideMenu();
        ProductsListPage productsListPage = homePage.clickAllVideoGamesInSideMenu();

        productsListPage.filterByFreeShipping();
        productsListPage.filterByConditionNew();
        productsListPage.sortPriceHighToLow();
        ProductsListPage.CartSummary cartSummary = productsListPage.addItemsBelowThresholdToCart(15000);
        CartPage cartPage = productsListPage.navigateToCart();

        Assert.assertEquals(cartSummary.getItemCount(), cartPage.getCountOfCartItems(),
                "count of cart items mismatch");
        int totalCartAmount = cartPage.getTotalCartAmount();
        Assert.assertEquals(cartSummary.getTotalPrice(), totalCartAmount
                , "cart amount mismatch");
        CheckOutPage checkOutPage = cartPage.navigateToCheckOut();

    }
}
