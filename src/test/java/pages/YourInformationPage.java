package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void pressContinue() {
        driver.findElement(continueButton).click();
    }

    public void pressCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void pressFinish() {
        driver.findElement(finishButton).click();
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public boolean isErrorMsDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
