package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static enums.TitleNaming.CART;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Корзина")
@Feature("Работа с товарами")
public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of(
                    "Sauce Labs Bike Light",
                    "Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Bolt T-Shirt"
            );

    @Story("Добавление товаров в корзину")
    @Test(description = "Проверка добавления нескольких товаров в корзину")
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getGoodsQuantity(), 6);
        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        productsPage.addToCart();
        assertEquals(productsPage.navigationPanel.checkCounterValue(), "4");
        assertEquals(productsPage.navigationPanel.checkCounterColor(), "rgba(226, 35, 26, 1)");
        cartPage.navigationPanel.entranceToCart();
        assertEquals(cartPage.getTitle(), CART.getDisplayName());
    }
}
