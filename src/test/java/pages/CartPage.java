package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void entranceToCart() {
        driver.findElement(cartLink).click();
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }
}
