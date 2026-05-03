package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class YourInformationPage extends BasePage {
    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By checkoutButton = By.cssSelector("#checkout");
    private final By continueButton = By.cssSelector("#continue");
    private final By finishButton = By.cssSelector("#finish");
    private final By firstNameField = By.cssSelector("#first-name");
    private final By lastNameField = By.cssSelector("#last-name");
    private final By postalCodeField = By.cssSelector("#postal-code");
    private final By errorMessage = By.xpath("//*[@data-test='error']");

    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить заголовок страницы")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Нажать кнопку Continue")
    public void pressContinue() {
        driver.findElement(continueButton).click();
    }

    @Step("Нажать кнопку Checkout")
    public void pressCheckout() {
        driver.findElement(checkoutButton).click();
    }

    @Step("Нажать кнопку Finish")
    public void pressFinish() {
        driver.findElement(finishButton).click();
    }

    @Step("Заполнить форму данными: имя '{firstName}', фамилия '{lastName}', индекс '{postalCode}'")
    public void fillInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    @Step("Проверить, что отображается сообщение об ошибке")
    public boolean isErrorMsDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
