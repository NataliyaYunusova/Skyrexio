package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class YourInformationTest extends BaseTest {

    @Test
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

    @Test
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
