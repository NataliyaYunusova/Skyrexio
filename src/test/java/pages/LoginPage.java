package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector(DATA_TEST_PATTERN.formatted("login-button"));
    private final By errorMessage = By.xpath("//*[@data-test='error']");
    private final By errorMsgTxt = By.xpath("//h3[contains(text(), 'Epic sadface')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть сайт saucedemo")
    public LoginPage open() {
        driver.get(BASE_URL);

        return this;
    }

    @Step("Выполнить вход в сиситему под пользователем {user.login}")
    public LoginPage login(User user) {
        driver.findElement(userField).sendKeys(user.getLogin());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(submitButton).click();

        return this;
    }

    @Step("Проверить отображение сообщения об ошибке")
    public boolean isErrorMsDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    @Step("Получить текст сообщения об ошибке")
    public String getErrorMessage() {
        return driver.findElement(errorMsgTxt).getText();
    }
}
