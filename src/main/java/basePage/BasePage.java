package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import webDriver.WebDriverSingleton;

import java.time.Duration;

public class BasePage {
    protected ConfigReader configReader = new ConfigReader("src/main/resources/config.properties");
    private WebDriver driver = WebDriverSingleton.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    ;

    protected void click(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    protected void clickByJs(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        js.executeScript("arguments[0].click();", driver.findElement(element));
    }

    protected void clickByJs(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].click();", element);
    }

    protected void type(By element, String text) {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        js.executeScript("arguments[0].value = arguments[1];", driver.findElement(element), text);
    }

    protected void selectFromDropdownByValue(By dropdownLocator, String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(dropdownLocator));
        Select sortDropdown = new Select(driver.findElement(dropdownLocator));
        sortDropdown.selectByValue(value);
    }

    protected void wait(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void scrollIntoView(By element) {
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
                driver.findElement(element));
    }

    protected void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
                element);
    }

    protected int getWebElementsListSize(By elements) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
        return driver.findElements(elements).size();
    }

    protected String getProperty(String key) {
        return configReader.getProperty(key);
    }
}
