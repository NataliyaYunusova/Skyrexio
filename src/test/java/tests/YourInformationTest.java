package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Оформление заказа")
@Feature("Checkout: Your Information")
public class YourInformationTest extends BaseTest {

    @Story("Успешное заполнение формы и завершение заказа")
    @Test(description = "Проверка полного оформления заказа с валидными данными")
    public void checkGoodsInYourInformation() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        yourInformationPage.navigationPanel.entranceToCart();
        yourInformationPage.pressCheckout();
        assertEquals(yourInformationPage.getTitle(), "Checkout: Your Information");
        yourInformationPage.fillInformation("Alice", "Selezneva", "12345");
        yourInformationPage.pressContinue();
        assertEquals(yourInformationPage.getTitle(), "Checkout: Overview");
        yourInformationPage.pressFinish();
        assertEquals(yourInformationPage.getTitle(), "Checkout: Complete!");
    }

    @Story("Проверка валидации обязательных полей")
    @Test(description = "Проверка ошибки при пустых полях формы")
    public void emptyFieldsInYourInformation() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        yourInformationPage.navigationPanel.entranceToCart();
        yourInformationPage.pressCheckout();
        assertEquals(yourInformationPage.getTitle(), "Checkout: Your Information");
        yourInformationPage.pressContinue();
        assertTrue(yourInformationPage.isErrorMsDisplayed(), "Error: First Name is required");
    }
}
