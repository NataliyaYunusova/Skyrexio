package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.TitleNaming.PRODUCTS;
import static io.qameta.allure.Allure.step;
import static org.testng.Assert.*;
import static user.UserFactory.*;

@Epic("Авторизация")
@Feature("Login page")
@Owner("Юнусова Наталья yunusova.nv@gmail.com")
public class LoginTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Skyrexio")
    @Issue("Skyrexio")
    @Story("Проверка авторизации с корректными данными пользователя")
    @Test(description = "Проверка авторизации с корректными данными пользователя")
    public void checkLogin() {
        loginPage
                .open()
                .login(withAdminPermission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @Story("Проверка авторизации с некорректными данными пользователя")
    @Test(dataProvider = "incorrectData", description = "Проверка авторизации с некорректными данными пользователя")
    public void checkLockedUserIncorrectLogin(String testName, User user, String errorMessage) {
        step("Тест-кейс: " + testName, () -> {
            loginPage
                    .open()
                    .login(user);

            assertTrue(loginPage.isErrorMsDisplayed());
            assertEquals(loginPage.getErrorMessage(), errorMessage);
        });
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {"Неправильный логин", UserFactory.withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {"Пустой логин", UserFactory.withEmptyLogin(), "Epic sadface: Username is required"},
                {"Пустой пароль", UserFactory.withEmptyPassword(), "Epic sadface: Password is required"},
                {"Неверные логин и пароль", UserFactory.withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
