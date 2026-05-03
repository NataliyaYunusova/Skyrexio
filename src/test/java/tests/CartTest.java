package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Корзина")
@Feature("Просмотр корзины")
public class CartTest extends BaseTest {
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";

    @Story("Отображение добавленного товара в корзине")
    @Test(description = "Проверка, что добавленный товар отображается в корзине")
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(goodsName);
        cartPage.navigationPanel.entranceToCart();

        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
