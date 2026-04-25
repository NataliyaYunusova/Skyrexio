package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(dataProvider = "incorrectData")
    public void checkLockedUserIncorrectLogin(User user, String errorMessage) {
        loginPage.open();
        loginPage.login(user);

        assertTrue(loginPage.isErrorMsDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {UserFactory.withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {new User("", "secret_sauce"), "Epic sadface: Username is required"},
                {new User("standard_user", ""), "Epic sadface: Password is required"},
                {UserFactory.withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
