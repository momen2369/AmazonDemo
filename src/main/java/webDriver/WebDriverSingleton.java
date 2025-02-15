package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run without UI

        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset instance
        }
    }
}

