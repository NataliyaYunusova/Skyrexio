package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static pages.BasePage.DATA_TEST_PATTERN;

public class NavigationPanel {
    private final WebDriver driver;
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти в корзину")
    public void entranceToCart() {
        driver.findElement(cartLink).click();
    }

    @Step("Получить значение счетчика товаров в корзине")
    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Получить цвет значка корзины")
    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }
}
